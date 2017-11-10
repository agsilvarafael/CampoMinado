package br.edu.so.main;

import br.edu.so.control.ThreadPosicionaBomba;
import br.edu.so.model.CampoMinado;
import br.edu.so.model.CampoMinadoDificuldades;
import br.edu.so.view.MainFrame;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CampoMinado mapa = new CampoMinado();
		for (int i = 0; i < 10; i++)
			new ThreadPosicionaBomba(mapa, CampoMinadoDificuldades.FACIL);
		Thread.sleep(500);
		MainFrame mFrame = new MainFrame(mapa);
		// TODO: Olhar como espera uma sequencia de threads morrerem

	}

}
