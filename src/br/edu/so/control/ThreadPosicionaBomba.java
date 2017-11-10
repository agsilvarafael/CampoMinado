package br.edu.so.control;

import java.util.Random;

import br.edu.so.model.CampoMinadoDificuldades;
import br.edu.so.model.CampoMinado;

/**
 * Classe que possui uma thread respons�vel por achar uma posi��o aleat�ria para
 * a bomba. Ela gera um n�mero aleat�rio refente � posi��o, verifica se n�o h�
 * bomba no local, e ent�o chama o m�todo setBbomba, da classe CampoMinado.
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
			// Se colocar a bomba, a thread morre, se n�o, ela tenta com outros n�meros
			if (campoM.setBomba(linha, coluna))
				break;
		}
		// Morre
	}

}
