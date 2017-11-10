package br.edu.so.control;

import br.edu.so.model.CampoMinado;

/**
 * Abre casas adjacentes � casas vaziaClicada. Se a casa adjacente � vazia, ela
 * cria outras threads para as casas adjacentes
 *
 */
public class ThreadAbrirCasasVazias implements Runnable {
	CampoMinado mapa;
	Integer linha;
	Integer coluna;
	ControleAbreCasa ca;

	public ThreadAbrirCasasVazias(CampoMinado mapa, Integer linha, Integer coluna, ControleAbreCasa ca) {
		this.mapa = mapa;
		this.linha = linha;
		this.coluna = coluna;
		this.ca = ca;
	}

	@Override
	public void run() {
		// TODO:
		// Testa se esta aberta
		// Se n�o, abre. Se for vazia, chama outra Thread para ela.
		// ca.abrirCasa(linha, coluna);
	}

}
