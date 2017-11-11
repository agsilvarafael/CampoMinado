package br.edu.so.main;

import br.edu.so.control.ThreadPosicionaBomba;
import br.edu.so.model.CampoMinado;
import br.edu.so.model.CampoMinadoDificuldades;
import br.edu.so.view.MainFrame;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CampoMinado campoMinado = new CampoMinado();
		campoMinado.novoJogo(CampoMinadoDificuldades.DIFICIL);
		for (int i = 0; i < 10; i++)
			new ThreadPosicionaBomba(campoMinado);
		Thread.sleep(500);
		MainFrame mFrame = new MainFrame(campoMinado);
		// Thread.sleep(500);
		// mFrame.repaint();
		// TODO: Olhar como espera uma sequencia de threads morrerem

	}

}
