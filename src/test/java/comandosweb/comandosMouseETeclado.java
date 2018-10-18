package comandosweb;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class comandosMouseETeclado {
	Robot robot = null;

	public comandosMouseETeclado() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void moverParaCima() {
		robot.keyPress(KeyEvent.VK_UP);
	}

	/**
	 * 
	 */
	public void moverParaBaixo() {
		robot.keyPress(KeyEvent.VK_DOWN);
	}

	/**
	 * 
	 */
	public void moverParaEsquerda() {
		robot.keyPress(KeyEvent.VK_LEFT);
	}

	/**
	 * 
	 */
	public void moverParaDireita() {
		robot.keyPress(KeyEvent.VK_RIGHT);
	}

	/**
	 * 
	 */
	public void pressionarEnter() {
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * @param quantidade
	 *            de BACK_SPACE
	 */
	public void backspace(int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
		}
	}

	/**
	 * @param quantidade
	 *            de DELETE
	 */
	public void delete(int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			robot.keyPress(KeyEvent.VK_DELETE);
		}
	}

	/**
	 * @param quantidade
	 *            de ESPAÇO
	 */
	public void espaco(int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			robot.keyPress(KeyEvent.VK_SPACE);
		}
	}

	/**
	 * 
	 */
	public void esc() {
		robot.keyPress(KeyEvent.VK_ESCAPE);
	}

	/**
	 * 
	 */
	public void control() {
		robot.keyPress(KeyEvent.VK_CONTROL);
	}

	/**
	 * 
	 */
	public void shift() {
		robot.keyPress(KeyEvent.VK_SHIFT);
	}

	/**
	 * 
	 */
	public void alt() {
		robot.keyPress(KeyEvent.VK_ALT);
	}

	/**
	 * 
	 */
	public void pageUp() {
		robot.keyPress(KeyEvent.VK_PAGE_UP);
	}

	/**
	 * 
	 */
	public void pageDown() {
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	}

	/**
	 * 
	 */
	public void end() {
		robot.keyPress(KeyEvent.VK_END);
	}

	/**
	 * 
	 */
	public void home() {
		robot.keyPress(KeyEvent.VK_HOME);
	}

	/**
	 * 
	 */
	public void windows() {
		robot.keyPress(KeyEvent.VK_WINDOWS);
	}

	/**
	 * 
	 */
	public void tab() {
		robot.keyPress(KeyEvent.VK_TAB);
	}

	/**
	 * 
	 */
	public void capsLock() {
		robot.keyPress(KeyEvent.VK_CAPS_LOCK);
	}

	/**
	 * 
	 */
	public void copiar() {
		robot.keyPress(KeyEvent.VK_COPY);
	}

	/**
	 * 
	 */
	public void cortar() {
		robot.keyPress(KeyEvent.VK_CUT);
	}

	/**
	 * 
	 */
	public void colar() {
		robot.keyPress(KeyEvent.VK_PASTE);
	}

	/**
	 * @param quantidade
	 *            de clique com botão esquerdo do mouse
	 */
	public void clicarBotaoEsquerdoMouse(int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			robot.mousePress(MouseEvent.BUTTON1);
		}
	}

	/**
	 * @param quantidade
	 *            de clique com botão direito do mouse
	 */
	public void clicarBotaoDireitoMouse(int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			robot.mousePress(MouseEvent.BUTTON2);
		}
	}

	/**
	 * @param quantida
	 *            de rolagem
	 */
	public void rolar(int quantidadeRolagem) {
		robot.mouseWheel(quantidadeRolagem);
	}

	/**
	 * @param mover
	 *            para coordenada X
	 * @param mover
	 *            para coordenada Y
	 */
	public void moverParaCoordenada(int coordenadaX, int coordenadaY) {
		robot.mouseMove(coordenadaX, coordenadaY);
	}
}