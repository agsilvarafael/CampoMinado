package br.edu.so.control;

import java.util.Random;

import br.edu.so.model.CampoMinadoDificuldades;
import br.edu.so.model.CampoMinado;

/**
 * Classe que possui uma thread responsável por achar uma posição aleatória para
 * a bomba. Ela gera um número aleatório refente à posição, verifica se não há
 * bomba no local, e então chama o método setBbomba, da classe CampoMinado.
 * 
 */
public class ThreadPosicionaBomba implements Runnable {

	private Random r;
	private CampoMinadoDificuldades dificuldade;
	private CampoMinado campoM;

	public ThreadPosicionaBomba(CampoMinado mapa, CampoMinadoDificuldades dificuldade) {
		this.campoM = mapa;
		this.dificuldade = dificuldade;
		r = new Random();
		(new Thread(this)).start();
	}

	@Override
	public void run() {
		while (true) {
			// Random
			int linha = r.nextInt(dificuldade.getLinhas());
			int coluna = r.nextInt(dificuldade.getColunas());
			// Se colocar a bomba, a thread morre, se não, ela tenta com outros números
			if (campoM.setBomba(linha, coluna))
				break;
		}
		// Morre
	}

}
