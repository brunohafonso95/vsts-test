package comandosweb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável por conter comandos que executam intera��es
 *            com a p�gina da web. Os m�todos contidos na classe s�o todos
 *            publicos e para utiliza-los, n�o � necess�rio passar o WebDriver
 *            como parametro
 */
public class comandosBasicos {

	protected WebDriver driver;
	protected Actions action;
	protected WebDriverWait wait;

	/**
	 * @Descricao m�todo construtor, define que sempre que a classe for
	 *            instanciada, � necess�rio passar o driver como parametro
	 * @param WebDriver
	 */
	public comandosBasicos(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
	}

	/**
	 * @Descricao Mudar de aba do navegador
	 * @param indiceAba 
	 *            da aba. Ex.: 0, 1, 2 ...
	 */
	/// - methodDescription:
    ///     title: masterblasterblum
    ///     text_description: Método responsável por
    ///     parameters: 
    ///     ex: ComandosBasicos comBasico = new ComandosBasicos(driver);
    ///     return_description: Método não tem retorno.
    ///     return: void
	public void mudarAba(int indiceAba) {
		try {
			driver.switchTo().window((String) driver.getWindowHandles().toArray()[indiceAba]);
		} catch (Exception e) {
			String valorError = "Este Indice de Aba não existe!\n\nUse um valor Valido!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	/**
	 * @Descricao Trocar de Janela
	 * @param indiceJanela
	 */
	public void trocarJanela(Integer indiceJanela) {
		try {
			Set<String> handles = driver.getWindowHandles();
			Object[] it = handles.toArray();

			driver.switchTo().window((String) it[indiceJanela]);
		} catch (Exception e) {
			String valorError = "Este Indice de Janela não existe!\n\nUse um valor Valido!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	/**
	 * @Descricao Procurar um elemento espec�fico na p�gina. Para utiliza-lo �
	 *            necess�rio informar um localizador (id, className, cssSelector,
	 *            Xpath, etc) afim de identific�-lo na p�gina
	 * @param seletorElemento
	 */

	public void borda(WebElement seletorElemento) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.border = 'medium solid red';", seletorElemento);
	}

	public WebElement encontra(String name) {
		WebElement elemento = null;
		while (true) {
			try {
				elemento = driver.findElement(By.id(name));
				break;
			} catch (Exception e) {
			}
			try {
				elemento = driver.findElement(By.name(name));
				break;
			} catch (Exception e1) {
			}
			try {
				elemento = driver.findElement(By.tagName(name));
				break;
			} catch (Exception e2) {
			}
			try {
				elemento = driver.findElement(By.cssSelector(name));
				break;
			} catch (Exception e3) {
			}
			try {
				elemento = driver.findElement(By.linkText(name));
				break;
			} catch (Exception e4) {
			}
			try {
				elemento = driver.findElement(By.partialLinkText(name));
				break;
			} catch (Exception e5) {
			}
			try {
				elemento = driver.findElement(By.xpath(name));
				break;
			} catch (Exception e6) {
				String valorError = "Nenhum elemento foi identificado!";
				throw new java.lang.Error(valorError);
			}
		}
		borda(elemento);
		return elemento;
	}

	// novo metodo
	public WebElement encontra(String seletorElementoPai, String seletorElementoFilho) {
		WebElement elementoPai = encontra(seletorElementoPai);
		WebElement elemento = null;

		while (true) {
			try {
				elemento = elementoPai.findElement(By.id(seletorElementoFilho));
				break;
			} catch (Exception e) {
			}
			try {
				elemento = elementoPai.findElement(By.name(seletorElementoFilho));
				break;
			} catch (Exception e1) {
			}
			try {
				elemento = elementoPai.findElement(By.tagName(seletorElementoFilho));
				break;
			} catch (Exception e2) {
			}
			try {
				elemento = elementoPai.findElement(By.cssSelector(seletorElementoFilho));
				break;
			} catch (Exception e3) {
			}
			try {
				elemento = elementoPai.findElement(By.linkText(seletorElementoFilho));
				break;
			} catch (Exception e4) {
			}
			try {
				elemento = elementoPai.findElement(By.partialLinkText(seletorElementoFilho));
				break;
			} catch (Exception e5) {
			}
			try {
				elemento = elementoPai.findElement(By.xpath(seletorElementoFilho));
				break;
			} catch (Exception e6) {
				String valorError = "Nenhum elemento foi identificado!";
				throw new java.lang.Error(valorError);
			}
		}
		borda(elemento);
		return elemento;
	}

	public void elementoExiste(String seletorElemento) {
		assertTrue(encontra(seletorElemento) != null);
	}

	public void elementoEstaVisivel(String seletorElemento) {
		assertTrue(encontra(seletorElemento).isDisplayed());
	}

	public void elementoEstaHabilitado(String seletorElemento) {
		assertTrue(encontra(seletorElemento).isEnabled());
	}

	/**
	 * @param elemento
	 * 
	 */
	public void esperarElemento(String elemento) {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(encontra(elemento)));
	}

	/**
	 * @param elemento
	 * @param tempo
	 *            limite de espera
	 */
	public void esperarElemento(String elemento, int time) {
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(encontra(elemento)));
	}

	/**
	 * @Descricao Escrever em algum campo
	 * @param elemento
	 * @param texto
	 */
	public void escrever(String elemento, String texto) {
		try {
			encontra(elemento).sendKeys(texto);
		} catch (Exception e) {
			String valorError = "Este elemento não tem entrada para texto!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	public void escrever(WebElement elemento, String texto) {
		try {
			elemento.sendKeys(texto);
		} catch (Exception e) {
			String valorError = "Este elemento não tem entrada para texto!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	/**
	 * @Descricao Limpar campo
	 * @param seletorElemento
	 * 
	 */
	public void limpar(String seletorElemento) {
		try {
			encontra(seletorElemento).clear();
		} catch (Exception e) {
			String valorError = "Este elemento não tem entrada para texto!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	/**
	 * @Descricao Clicar em um elemento
	 * @param seletorElemento
	 */
	public void clicar(String seletorElemento) {
		try {
			encontra(seletorElemento).click();
		} catch (Exception e) {
			String valorError = "Este elemento não é clicavel!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}

	}

	/**
	 * @Descricao Clicar em um ou mais elementos
	 * @param seletorElementos
	 */
	public void clicarElementos(List<String> seletorElementos) {
		for (String seletorElemento : seletorElementos) {
			clicar(seletorElemento);
		}
	}

	/**
	 * @Descricao Verificar se o Radio Button est� selecionado
	 * @param seletorElemento
	 * @return boolean
	 */
	public void verificarSeRadioEstaMarcado(String seletorElemento) {
		assertTrue(encontra(seletorElemento).isSelected());
	}

	/**
	 * @Descricao Obter texto do elemento. O texto � retornado como uma String
	 * @param seletorElemento
	 * @return String
	 */
	public String obterTexto(String seletorElemento) {
		String text = null;
		try {
			text = encontra(seletorElemento).getText();
		} catch (Exception e) {
			String valorError = "Este elemento não tem texto de retorno!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
		return text;
	}

	/**
	 * @Descricao limpar valor com backspace
	 * @param seletorElemento
	 */
	public void limparValorComBackspace(String seletorElemento) {
		WebElement elements = encontra(seletorElemento);
		try {
			elements.sendKeys(Keys.BACK_SPACE);
		} catch (Exception e) {
			String valorError = "Este elemento não tem entrada para texto!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	/**
	 * @Descricao Pegar Valor do CSS. elementoCss: nome do elemento CSS a ser obtido
	 *            o valor. Ex. Display
	 * @param seletorElemento
	 * @param propriedadeCSS
	 * @return String
	 */
	public String pegarValorCss(String seletorElemento, String propriedadeCSS) {
		String text = null;
		try {
			text = encontra(seletorElemento).getCssValue(propriedadeCSS);
		} catch (Exception e) {
			String valorError = "Este elemento não tem um valor de CSS para a propriedade informada!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
		return text;
	}

	/**
	 * @Descricao Obter valor do "Attribute"
	 * @param seletorElemento
	 * @return atriutoElemento
	 */
	public String obterAtributoElemento(String seletorElemento, String atriutoElemento) {
		return encontra(seletorElemento).getAttribute(atriutoElemento);
	}

	/**
	 * @Descricao Verificar se o check box est� marcado
	 * @param seletorElemento
	 * @return boolean
	 */
	public boolean verificarSeOcheckBoxEstaMarcado(String seletorElemento) {
		return encontra(seletorElemento).isSelected();
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Urls ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Abrir uma nova URL em um novo browser.
	 * @param URL
	 * 
	 */
	public void abrirUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			String valorError = "Use uma Url Valida\nhttp://[seu destino]\n Exemplo:\n\nhttp://google.com.br";
			// System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	/**
	 * @Descricao Valida t�tulo da aba do browser
	 * @param tituloPagina
	 */
	public void validarTituloDoBrowser(String tituloPagina) {
		assertEquals(driver.getTitle(), tituloPagina);
	}

	/**
	 * @Descricao Valida a URL atual
	 * @param pageURL
	 * 
	 */
	public void validarUrlAtual(String pageURL) {
		assertEquals(pageURL, driver.getCurrentUrl());
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Combos ***********
	 * 
	 * 
	 * 
	 ***********************************/

	public Select select(String seletorElemento) {
		WebElement webElement = encontra(seletorElemento);
		Select combo = new Select(webElement);
		return combo;
	}

	/**
	 * @Descricao Selecionar combo por texto vis�vel
	 * @param elemento
	 * @param valor
	 */
	public void selecionarComboPorValor(String seletorElemento, String valorOpcao) {
		try {
			select(seletorElemento).selectByValue(valorOpcao);
		} catch (Exception e) {
			String valorError = "Não existe este valor dentro da desde select";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	public void selecionarComboPorIndice(String seletorElemento, Integer indiceOpcao) {
		try {
			select(seletorElemento).selectByIndex(indiceOpcao);
		} catch (Exception e) {
			String valorError = "Não existe este Index dentro da deste select";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	/**
	 * @Descricao Obter texto da primeira posi��o do combo
	 * @param seletorElemento
	 * @return String
	 */
	public String obterTextoVisivelDoCombo(String seletorElemento) {
		return select(seletorElemento).getFirstSelectedOption().getText();
	}

	public List<WebElement> pegarOpcoesCombo(String seletorElemento) {
		List<WebElement> options = select(seletorElemento).getOptions();
		return options;
	}

	/**
	 * @Descricao Obter a quantidade de op��es do combo
	 * @param seletorElemento
	 * @return Integer
	 */

	public Integer obterQuantidadeOpcoesCombo(String seletorElemento) {
		List<WebElement> options = pegarOpcoesCombo(seletorElemento);
		return options.size();
	}

	/**
	 * @Descricao Passar um texto e verificar se existe a op��o no combo. Ex.:
	 *            Se quiser verificar num combo de cidade a op��o "S�o Paulo",
	 *            dever� ser passado "S�o Paulo" como par�metro
	 * @param seletorElemento
	 * @param opcaoTexto
	 * @return
	 * @return boolean
	 */
	public boolean verificarSeExisteOpcaoNoSelect(String seletorElemento, String opcaoTexto) {
		boolean resultado = false;
		List<WebElement> options = pegarOpcoesCombo(seletorElemento);
		for (WebElement option : options) {
			if (option.getText().equals(opcaoTexto)) {
				resultado = true;
				return resultado;
			}
		}
		return resultado;
	}

	public void quebrarSeNaoExisteOpcaoNoSelect(String seletorElemento, String textoOpcao) {
		assertTrue(verificarSeExisteOpcaoNoSelect(seletorElemento, textoOpcao));
	}

	/**
	 * @Descricao Desmarcar combo de acordo com o texto
	 * @param seletorElemento
	 * @param valor
	 */
	public void desmarcarComboPorTextoVisivel(String seletorElemento, String textoOpcao) {
		try {
			select(seletorElemento).deselectByVisibleText(textoOpcao);
		} catch (Exception e) {
			String valorError = "Não existe este valor dentro da desde select";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	/**
	 * @Descricao Obter todos os textos do combo
	 * @param seletorElemento
	 * @return List
	 */
	public List<String> obterTextosCombo(String seletorElemento) {
		List<String> listaDeTexto = new ArrayList<String>();
		int quantidade = obterQuantidadeOpcoesCombo(seletorElemento);
		System.out.println(quantidade);
		for (int i = 0; i < quantidade; i++) {
			listaDeTexto.add(select(seletorElemento).getOptions().get(i).getText());
		}
		return listaDeTexto;
	}

	/**
	 * @Descricao Obter uma lista das op��es que est�o selecionadas no combo
	 * @param elemento
	 * @return lista de String
	 */
	public List<String> obterTodasAsOpcoesSelecionadasNoCombo(String elemento) {
		List<WebElement> allSelectedOptions = select(elemento).getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Frames ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Entrar no frame
	 * @param seletorElemento
	 */
	public void entrarFrame(String seletorElemento) {
		try {
			sairFrame();
			driver.switchTo().frame(seletorElemento);
		} catch (Exception e) {
			String valorError = "Não existe este  frame como padrão!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	/**
	 * @Descricao Sair do frame atual e voltar pra estrutura HTML padr�o
	 */
	public void sairFrame() {
		driver.switchTo().defaultContent();
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Alerts ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Aceitar o alerta
	 */
	private Alert getAlert() {
		Alert alert = null;
		try {
			alert = driver.switchTo().alert();
		} catch (Exception e) {
			String valorError = "Não existe um alerta na tela";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
		return alert;
	}

	public void aceitarAlerta() {
		try {
			Alert alert = getAlert();
			alert.accept();
		} catch (Exception e) {
			String valorError = "Não é um alerta de aceitação!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}

	}

	/**
	 * @Descricao Obter texto do alerta
	 * @return String
	 */
	public String obterTextoDoAlerta() {
		String text = null;
		try {
			Alert alert = getAlert();
			text = alert.getText();
		} catch (Exception e) {
			String valorError = "Não ha texto em alert para ser extraído!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
		return text;
	}

	/**
	 * @Descricao Negar Alerta
	 */
	public void negarAlerta() {
		try {
			Alert alert = getAlert();
			alert.dismiss();
		} catch (Exception e) {
			String valorError = "Não é um alerta de rejeição!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}

	}

	/**
	 * @Descricao Escrever no Alerta
	 * @param elemento
	 */
	public void escreverNoAlerta(String conteudo) {
		try {
			Alert alert = getAlert();
			alert.sendKeys(conteudo);
		} catch (Exception e) {
			String valorError = "Não é um alerta de introdução de texto!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}

	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Esperas **********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @param elemento.
	 * @param tempo
	 *            limite de espera
	 * @return
	 */
	public WebElement esperarSerClicavel(String elemento, int time) {
		wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(encontra(elemento)));
	}

	/**
	 * @Descricao
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 * @return
	 */
	public Boolean esperarSerSelecionavel(String elemento, int time) {
		wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeSelected(encontra(elemento)));
	}

	/**
	 * @Descricao Esperar a p�gina estar na URL passada via par�metro
	 * @param URL
	 * @param tempoLimiteDeEspera
	 * @return
	 */
	public Boolean esperarUrlSerCarregada(String url, int tempoLimiteDeEspera) {
		wait = new WebDriverWait(driver, tempoLimiteDeEspera);
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	/**
	 * @Descricao Esperar elemento ser clic�vel, clicar e escrever
	 * @param elemento
	 * @param texto
	 * @param tempoLimiteDeEspera
	 */
	public void esperarSerClicavelClicarEscrever(String elemento, String valor, int tempoLimiteDeEspera) {
		esperarSerClicavel(elemento, tempoLimiteDeEspera);

		escrever(elemento, valor);

	}

	/**
	 * @Descricao Esperar visibilidade do elemento
	 * @param tempoLimiteDeEspera
	 */
	public void esperaSerVisivel(String elemento, int tempoLimiteDeEspera) {
		wait = new WebDriverWait(driver, tempoLimiteDeEspera);
		wait.until(ExpectedConditions.visibilityOf(encontra(elemento)));
	}

	/**
	 * @param elemento.
	 * @param tempo
	 *            limite de espera
	 * @return
	 */
	public WebElement esperarSerClicavel(String elemento) {
		wait = new WebDriverWait(driver, 15);
		return wait.until(ExpectedConditions.elementToBeClickable(encontra(elemento)));
	}

	/**
	 * @Descricao
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 * @return
	 */
	public Boolean esperarSerSelecionavel(String elemento) {
		wait = new WebDriverWait(driver, 15);
		return wait.until(ExpectedConditions.elementToBeSelected(encontra(elemento)));
	}

	/**
	 * @Descricao Esperar a p�gina estar na URL passada via par�metro
	 * @param URL
	 * @param tempoLimiteDeEspera
	 * @return
	 */
	public Boolean esperarUrlSerCarregada(String url) {
		wait = new WebDriverWait(driver, 15);
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	/**
	 * @Descricao Esperar elemento ser clic�vel, clicar e escrever
	 * @param elemento
	 * @param texto
	 * @param tempoLimiteDeEspera
	 */
	public void esperarSerClicavelClicarEscrever(String elemento, String valor) {
		esperarSerClicavel(elemento);
		escrever(elemento, valor);
	}

	/**
	 * @Descricao Esperar visibilidade do elemento
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	public void esperaSerVisivel(String elemento) {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(encontra(elemento)));
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * ****** Utilidades e Ações *********
	 * 
	 * 
	 * 
	 *************************************/

	public void captura(String string) throws IOException {

		File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destino = new File("./target/relatorios/screenshot/" + string + ".png");
		FileUtils.copyFile(shot, destino);
	}

	/**
	 * @Descricao Esperar elemento ser clic�vel, ap�s, limpar o campo
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	public void esperarElementoSerClicavelLimparCampo(String elemento, int tempoLimiteDeEspera) {
		esperarSerClicavel(elemento, tempoLimiteDeEspera);
		limpar(elemento);
	}

	public void encerra() {
		// Encerra o driver
		try {
			driver.close();
			driver.quit();
		} catch (Exception e) {
			System.out.println("Nenhum Driver aberto");
		}
	}

	public void simule_click(String elemento) {
		try {
			action.click(encontra(elemento));
			action.perform();
		} catch (Exception e) {
			String valorError = "Não é um elemento clicavel!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}

	}

	public void simule_escrever(String elemento, String texto) {
		try {
			action.sendKeys(encontra(elemento), texto);
			action.perform();
		} catch (Exception e) {
			String valorError = "Não é um elemento com entrada para texto!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	public void simule_arrastar(String elemento, String elemento2) {
		try {
			action.dragAndDrop(encontra(elemento), encontra(elemento2));
			action.perform();
		} catch (Exception e) {
			String valorError = "Não é um elemento de arraste";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	public void simule_duplo_clique(String elemento) {
		try {
			action.doubleClick(encontra(elemento));
			action.perform();
		} catch (Exception e) {
			String valorError = "Não é um elemento com entrada para cliques!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	public void simule_hover_mouse(String elemento) {
		try {
			action.moveToElement(encontra(elemento));
			action.perform();
		} catch (Exception e) {
			String valorError = "elemento nao esta visivel!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

}