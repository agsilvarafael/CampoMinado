package br.edu.so.control;

import java.util.Random;

import br.edu.so.model.CampoMinado;

/**
 * Classe que possui uma thread respons�vel por achar uma posi��o aleat�ria para
 * a bomba. Ela gera um n�mero aleat�rio refente � posi��o, verifica se n�o h�
 * bomba no local, e ent�o chama o m�todo setBbomba, da classe CampoMinado.
 * 
 * � subclasse de thread, para herdar o m�todo join, necess�rio no main.
 */
public class ThreadPosicionaBomba extends Thread {

	private Random r;
	private CampoMinado campoMinado;

	public ThreadPosicionaBomba(CampoMinado campoMinado) {
		this.campoMinado = campoMinado;
		r = new Random();
		(new Thread(this)).start();
	}

	@Override
	public void run() {
		while (true) {
			// Random
			int linha = r.nextInt(campoMinado.getDificuldade().getLinhas());
			int coluna = r.nextInt(campoMinado.getDificuldade().getColunas());
			// Se colocar a bomba, a thread morre, se n�o, ela tenta com outros n�meros
			if (campoMinado.setBomba(linha, coluna))
				break;
		}
		// Morre
	}

}
