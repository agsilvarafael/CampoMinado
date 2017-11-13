package br.edu.so.control;

import java.util.Random;

import br.edu.so.model.CampoMinado;

/**
 * Classe que possui uma thread responsável por achar uma posição aleatória para
 * a bomba. Ela gera um número aleatório refente à posição, verifica se não há
 * bomba no local, e então chama o método setBbomba, da classe CampoMinado.
 * 
 * É subclasse de thread, para herdar o método join, necessário no main.
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
			// Se colocar a bomba, a thread morre, se não, ela tenta com outros números
			if (campoMinado.setBomba(linha, coluna))
				break;
		}
		// Morre
	}

}
