package br.edu.so.main;

import java.util.ArrayList;

import br.edu.so.control.ThreadPosicionaBomba;
import br.edu.so.model.CampoMinado;
import br.edu.so.model.CampoMinadoDificuldades;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CampoMinado campoMinado = new CampoMinado();
		ArrayList<ThreadPosicionaBomba> arrayT = new ArrayList<>();
		
		campoMinado.novoJogo(CampoMinadoDificuldades.DIFICIL);
		for (int i = 0; i < 10; i++)
			arrayT.add(new ThreadPosicionaBomba(campoMinado));
		//Esprar threads terminarem 
		for (int i = 0; i < 10; i++)
			arrayT.get(i).join();
		

	}

}
