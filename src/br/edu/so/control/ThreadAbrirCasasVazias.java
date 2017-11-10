package br.edu.so.control;

import br.edu.so.model.CampoMinado;

/**
 * Abre casas adjacentes à casas vaziaClicada. Se a casa adjacente é vazia, ela
 * cria outras threads para as casas adjacentes
 *
 */
public class ThreadAbrirCasasVazias implements Runnable {
	CampoMinado campoMinado;
	Integer linha;
	Integer coluna;
	ControleAbreCasa ca;

	public ThreadAbrirCasasVazias(CampoMinado mapa, Integer linha, Integer coluna, ControleAbreCasa ca) {
		this.campoMinado = mapa;
		this.linha = linha;
		this.coluna = coluna;
		this.ca = ca;
		(new Thread(this)).start();
	}

	
	/**
	 * Está recebendo uma casa já aberta. Pode-se trocar pela opção de a thread abrir a casa dela
	 */
	@Override
	public void run() {
		// TODO:
		
		//Se casa é vazia, verifica as vizinhas
		if(campoMinado.isVazio(linha, coluna)){
			for (int i = linha - 1; i < linha + 2 && i < campoMinado.getDificuldade().getLinhas(); i++) {
				if (i < 0)
					continue;
				for (int j = coluna - 1; j < coluna + 2 && j < campoMinado.getDificuldade().getColunas(); j++) {
					if (j < 0)
						continue;
					
					// Testa se a a casa vizinha não está aberta
					if(!campoMinado.isCasaAberta(i, j)){
						// Abre a casa. 
						//TODO: Preciso passar o botão como parâmetro (implementar método getBotão no PainelJogoFacil) 
						//ca.abrirCasa(i, j, mapa, );
						
						//Se a casa for vazia, chama outra Thread para abrir os adjacentes à ela.
						if(campoMinado.isVazio(i, j))
							new ThreadAbrirCasasVazias(campoMinado, i, j, ca);
					}
				}
			}
		}
	
	}

}
