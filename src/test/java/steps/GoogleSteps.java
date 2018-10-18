package steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.Web;
import pageobject.GooglePage;

public class GoogleSteps {
    WebDriver driver;
    GooglePage google;


    @After
    public void finish() {
        google.encerra();
    }
    
    @Given("^Acessar pagina do google$")
    public void acessar_pagina_do_google() throws Throwable {
    	driver = new Web("google.com.br").getDriver();
    	google = new GooglePage(driver);
    }

    @When("^Fazer uma pesquisa$")
    public void fazer_uma_pesquisa() throws Throwable {
    	google.pesquisar("Facebook");
    }

    @Then("^Apresenta os resultados da pesquisa$")
    public void apresenta_os_resultados_da_pesquisa() throws Throwable {
    	google.validarTitulo("Facebook - Pesquisa Google");
    }

    @Then("^Apresenta os resultados errados$")
    public void apresenta_os_resultados_errados() throws Throwable {
    	google.validarTitulo("facebook - Pesquisa Google");
    }
}
