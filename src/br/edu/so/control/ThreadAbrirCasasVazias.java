package br.edu.so.control;

import br.edu.so.model.CampoMinado;
import br.edu.so.view.MainFrame;

/**
 * Abre casas adjacentes � casas vaziaClicada. Se a casa adjacente � vazia, ela
 * cria outras threads para as casas adjacentes
 *
 */
public class ThreadAbrirCasasVazias implements Runnable {
	private CampoMinado campoMinado;
	private Integer linha;
	private Integer coluna;
	private ControleAbreCasa ca;
	private MainFrame mf;

	public ThreadAbrirCasasVazias(CampoMinado campoMinado, Integer linha, Integer coluna, ControleAbreCasa ca,
			MainFrame mf) {
		this.campoMinado = campoMinado;
		this.linha = linha;
		this.coluna = coluna;
		this.ca = ca;
		this.mf = mf;
		(new Thread(this)).start();
	}

	/**
	 * Est� recebendo uma casa j� aberta. Pode-se trocar pela op��o de a thread
	 * abrir a casa dela
	 */
	@Override
	public void run() {
		// TODO:

		// Se casa � vazia, verifica as vizinhas
		if (campoMinado.isVazio(linha, coluna)) {
			for (int i = linha - 1; i < linha + 2 && i < campoMinado.getDificuldade().getLinhas(); i++) {
				if (i < 0)
					continue;
				for (int j = coluna - 1; j < coluna + 2 && j < campoMinado.getDificuldade().getColunas(); j++) {
					if (j < 0)
						continue;

					// Testa se a a casa vizinha n�o est� aberta
					if (!campoMinado.isCasaAberta(i, j)) {
						// Abre a casa.
						// TODO: Preciso passar o bot�o como par�metro (implementar m�todo getBot�o no
						// PainelJogoFacil)
						ca.abrirCasaSimples(i, j, campoMinado, mf.getPanelJogo().getBotao(i, j));

						// Se a casa for vazia, chama outra Thread para abrir os adjacentes � ela.
						if (campoMinado.isVazio(i, j))
							new ThreadAbrirCasasVazias(campoMinado, i, j, ca, mf);
					}
				}
			}
		}

	}

}
