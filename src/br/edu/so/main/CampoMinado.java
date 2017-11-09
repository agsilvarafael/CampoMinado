package br.edu.so.main;

import br.edu.so.model.Mapa;
import br.edu.so.view.MainFrame;

public class CampoMinado {

	public static void main(String[] args) throws InterruptedException {
		Mapa mapa = new Mapa();
		// for (int i = 0; i < 10; i++)
		// new ThreadPosicionaBomba(mapa, CampoMinadoDificuldades.FACIL);
		new MainFrame(mapa);
		// TODO: Olhar como espera uma sequencia de threads morrerem

	}

}
