package br.edu.so.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import br.edu.so.model.CampoMinado;

public class PainelJogoFacil extends JPanel {

	private CampoMinado campoMinado;

	public PainelJogoFacil(CampoMinado campoMinado) {
		setBackground(Color.BLUE);
		this.campoMinado = campoMinado;
		setSize(784, 420);
		setLayout(null);

		int tamBotoes = 40;
		ArrayList<ArrayList<BotaoCasa>> botoes = new ArrayList<>();
		for (int i = 0; i < campoMinado.getDificuldade().getLinhas(); i++) {
			ArrayList<BotaoCasa> aux = new ArrayList<>();
			for (int j = 0; j < campoMinado.getDificuldade().getColunas(); j++) {
				aux.add(new BotaoCasa(i, j, tamBotoes, campoMinado));
				aux.get(j).setLocation(tamBotoes * i, tamBotoes * j);
				this.add(aux.get(j));
			}
			botoes.add(aux);
		}
	}

}
