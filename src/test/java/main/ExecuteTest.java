package main;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/relatorios/resultado.json",
        "junit:target/relatorios/resultado.xml" }, features = "src/test/java/features", glue = "steps", monochrome = true)
public class ExecuteTest {
	
}
