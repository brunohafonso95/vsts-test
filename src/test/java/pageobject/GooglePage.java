package pageobject;

import comandosweb.comandosBasicos;
import org.openqa.selenium.WebDriver;

public class GooglePage extends comandosBasicos {
    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void pesquisar(String texto)
    {
        escrever("lst-ib", texto);
        clicar("doc-info");
        clicar("btnK");
    }

    public void validarTitulo(String titulo) {
        validarTituloDoBrowser(titulo);
    }
}
