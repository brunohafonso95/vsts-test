package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;;

public class Web {

	private String caminhoDriver;
	private WebDriver driver;

	public Web(String site) {
		// Driver Padrão Chrome
		caminhoDriver = System.getProperty("user.dir") + "\\target\\bin\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", caminhoDriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://" + site);
	}

	public Web(String navegador, String site) {
		// Escolher um navegador
		caminhoDriver = System.getProperty("user.dir") + "\\target\\bin\\drivers\\" + navegador + "driver.exe";
		System.setProperty("webdriver." + navegador + ".driver", caminhoDriver);
		driver = DriverBuilder(navegador, site);
		if(!navegador.contains("ie")) {
			driver.get("http://"+site);
		}
		driver.manage().window().maximize();
	}

	@SuppressWarnings("deprecation")
	public WebDriver DriverBuilder(String navegador, String site) {
		
		WebDriver validador = null;
		
		if (navegador.contains("firefox")) {
			validador = new FirefoxDriver();
		} else if (navegador.contains("ie")) {
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, site);
			validador = new InternetExplorerDriver(capability);
		} else {
			validador = new ChromeDriver();
		}
		
		return validador;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
