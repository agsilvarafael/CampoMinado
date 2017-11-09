package br.edu.so.control;

import java.util.Random;

import br.edu.so.model.CampoMinadoDificuldades;
import br.edu.so.model.Mapa;

/**
 * Classe que possui uma thread respons�vel por achar uma posi��o aleat�ria para
 * a bomba. Ela gera um n�mero aleat�rio refente � posi��o, verifica se n�o h�
 * bomba no local, e ent�o chama o m�todo setBbomba, da classe mapa.
 * 
 */
public class ThreadPosicionaBomba implements Runnable {

	private Random r;
	private CampoMinadoDificuldades dificuldade;
	private Mapa mapa;

	public ThreadPosicionaBomba(Mapa mapa, CampoMinadoDificuldades dificuldade) {
		this.mapa = mapa;
		this.dificuldade = dificuldade;
		r = new Random();
		(new Thread(this)).start();
	}

	@Override
	public void run() {
		while (true) {
			// Random
			int linha = r.nextInt(dificuldade.getAltura());
			int coluna = r.nextInt(dificuldade.getLargura());
			// Se colocar a bomba, a thread morre, se n�o, ela tenta com outros n�meros
			if (mapa.setBomba(linha, coluna))
				break;
		}
		// Morre
	}

}
