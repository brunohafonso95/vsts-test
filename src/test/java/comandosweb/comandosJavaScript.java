package comandosweb;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável por conter os métodos que executam ações na
 *            página utilizando o JavaScript
 */
public class comandosJavaScript extends comandosBasicos {

	protected JavascriptExecutor executor;
	
	public comandosJavaScript(WebDriver driver) {
		super(driver);
		executor = (JavascriptExecutor) driver;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @Descricao Método construtor, define que sempre que a classe for instanciada,
	 *            é necessário passar o driver como parâmetro
	 * @param driver
	 */


	/**
	 * @Descricao Clicar no elemento
	 * @param elemento
	 */
	public void JSclicar(String elemento) {
		try {
			String element = encontra(elemento).getAttribute("name");
			System.out.println(element);
			executor.executeScript("document.getElementsByName('"+ element + "')[0].click();");
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Rolar para baixo. O parâmetro "quantidade" define a quantidade de
	 *            rolagens
	 * @param quantidade
	 */
	public void JSrolarParaBaixo(int quantidade) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, " + quantidade + ")");
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Rolar para cima. O parâmetro "quantidade" define a quantidade de
	 *            rolagens
	 * @param quantidade
	 */
	public void JSrolarParaCima(int quantidade) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, " + quantidade + ")");
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Pegar valor do CSS. O parâmetro esperar receber o ID JSdo elemento.
	 *            VocÊ DEVE passa o parâmetro como um tipo String
	 * @param idDoElemento
	 * @return String: valor do css
	 */
	public String JSpegarValorCss(String idDoElemento) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			String value = (String) jse.executeScript(
					"" + "if (document.getElementById('" + idDoElemento + "').style.display == 'none'){   }");
			return value;
		} catch (NoSuchElementException e) {
			return null;
		} catch (TimeoutException e) {
			return null;
		} catch (ElementNotVisibleException e) {
			return null;
		}
	}

	/**
	 * @Descricao Mover para o elemento
	 * @param elemento
	 */
	public void JSmoverParaOelemento(String elemento) {
		WebElement element = encontra(elemento);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * @Descricao Escrever
	 * @param elemento
	 * @param texto
	 */
	public void JSescrever(String elemento, String texto) {
		String element = encontra(elemento).getAttribute("id");
		executor.executeScript("document.getElementById('" + element + "').value = '" + texto +"'");
	}
	
	
	public void borda(WebElement elemento) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].style.border = 'medium solid red';", elemento);
	}

	// e
	
	public void execute_Script(String script) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(script);
		} catch (Exception e) {
			String valorError = "Não é um script valido!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);

		}
	}

}