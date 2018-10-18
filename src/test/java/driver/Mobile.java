package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Mobile {

	private AppiumDriverLocalService servico;
	private AppiumServiceBuilder builder;
	private WebDriver mobile;
	private DesiredCapabilities desiredCapabilities;

	/// - methodDescription:
    ///     title: masterblaster
	///     text_description: 
	///			- Método responsável por fazer alguma coisa
	///			- muito legal 
    ///     parameters: 
	///			- String: teste1
	///			- int: teste2	
	///     ex: 
	/// 		- WebDriver driver = new WebDriver();
	///			- ComandosBasicos comBasico = new ComandosBasicos(driver);
    ///     return_description: Método não tem retorno.
    ///     return: void
	public Mobile() {
		// Appium Instalado via NPM (npm install -g appium)
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
		servico = AppiumDriverLocalService.buildService(builder);
		servico.start();
	}

	public WebDriver preparaEmulador(String aplicativo) {
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("platformVersion", "5.1");
		desiredCapabilities.setCapability("noReset", "True");
		desiredCapabilities.setCapability("appActivity", "br.com.mobc.alelocar.view.HomeActivity");
		desiredCapabilities.setCapability("app", "./target/bin/apps/" + aplicativo + ".apk" );
		desiredCapabilities.setCapability("appWaitActivity", "br.com.mobc.alelocar.view.HomeActivity");
		mobile = new AndroidDriver<WebElement>(servico, desiredCapabilities);
		return mobile;
	}

	public void finalizaEmulador() {
		mobile.quit();
		servico.stop();
	}
}
