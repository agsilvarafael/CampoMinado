package br.edu.so.control;

import br.edu.so.model.Mapa;

/**
 * Abre casas adjacentes à casas vaziaClicada. Se a casa adjacente é vazia, ela
 * cria outras threads para as casas adjacentes
 *
 */
public class ThreadAbrirCasasVazias implements Runnable {
	Mapa mapa;
	Integer linha;
	Integer coluna;
	ControleAbreCasa ca;

	public ThreadAbrirCasasVazias(Mapa mapa, Integer linha, Integer coluna, ControleAbreCasa ca) {
		this.mapa = mapa;
		this.linha = linha;
		this.coluna = coluna;
		this.ca = ca;
	}

	@Override
	public void run() {
		// TODO:
		// Testa se esta aberta
		// Se não, abre. Se for vazia, chama outra Thread para ela.
		ca.abrirCasa(linha, coluna);
	}

}
