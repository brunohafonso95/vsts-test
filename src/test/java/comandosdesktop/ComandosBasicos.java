package comandosdesktop;

import java.io.IOException;
import java.nio.file.Paths;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class ComandosBasicos {
	/// - methodDescription:
    ///     title: masterblasterblum
    ///     text_description: Método responsável por
    ///     parameters: 
    ///         - seletorElemento
    ///         - opcaoTexto
    ///     ex: ComandosBasicos comBasico = new ComandosBasicos(driver);
    ///     return_description: Método não tem retorno.
    ///     return: void
	Screen s = null;

	public ComandosBasicos() {
		s = new Screen();
		s.delayClick(200);
		s.delayType(200);

		// TODO Auto-generated constructor stub
	}

	public void Comando(String conteudo) {
		s.type(conteudo);
		Espera(1);
	}

	public void Escreve(String conteudo) {
		s.type(conteudo);
		s.type(Key.TAB);
	}

	public void Espera(int tempo) {
		try {
			Thread.sleep(tempo * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Escreve(String conteudo, int vezes) {
		int rodadas = 0;
		while (rodadas < vezes) {
			s.type(conteudo);
			rodadas++;
			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void Ctrl(String comando) {
		s.type(comando, KeyModifier.CTRL);
	}

	public void Ctrl(String comando, int vezes) {
		int rodadas = 0;
		while (rodadas < vezes) {
			s.type(comando, KeyModifier.CTRL);
			rodadas++;
		}
	}

	public void Alt(String comando) {
		s.type(comando, KeyModifier.ALT);
	}

	public void Alt(String comando, int vezes) {
		int rodadas = 0;
		while (rodadas < vezes) {
			s.type(comando, KeyModifier.ALT);
			rodadas++;
		}
	}

	public void Clica(String imagem) throws FindFailed {
		Match e = s.find("./target/bin/imagens/" + imagem + ".png");
		s.click("./target/bin/imagens/" + imagem + ".png");
		System.out.println(e);
	}

	public void CliqueDuplo(String imagem) throws FindFailed {
		s.doubleClick("./target/bin/imagens/" + imagem + ".png");
	}

	public void IniciaApplicacao(String app) throws IOException {
		String pathToFile = Paths.get("./target/bin/apps/" + app).toString();
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", pathToFile);
		pb.start();
	}

	public Match AguardeTela(String imagem) throws InterruptedException, FindFailed {
		boolean resultado = false;
		Match tela = null;
		while (resultado != true) {
			try {
				tela = s.find("./target/bin/imagens/" + imagem);
				resultado = true;
			} catch (Exception e) {
				resultado = false;
			}
		}
		return tela;
	}

	public Match AguardeTela(String imagem, int tempoEspera) throws InterruptedException, FindFailed {
		boolean resultado = false;
		Match tela = null;
		int contador = 0;
		while (resultado != true) {
			try {
				tela = s.find("./target/bin/imagens/" + imagem);
				resultado = true;
			} catch (Exception e) {
				if (contador >= tempoEspera) {
					resultado = true;
				} else {
					Thread.sleep(1000);
					contador++;
				}
			}
		}
		return tela;
	}
}
