package br.edu.so.control;

import br.edu.so.view.MainFrame;

/**
 * Assim que come�ar o novo jogo ou for selecionado uma nova dificuldade, esta
 * thread vai reconstruir a interface em paralelo �s threads que posicionam as
 * bombas
 */
public class ThreadConstroiPainelMapa implements Runnable {
	MainFrame mainFrame;
	
	public ThreadConstroiPainelMapa(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		(new Thread(this)).start();
	}

	@Override
	public void run() {
		mainFrame.reiniciar();
	}

}
