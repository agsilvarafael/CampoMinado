package br.edu.so.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import br.edu.so.model.CampoMinado;

public class PainelJogoFacil extends JPanel {

	private CampoMinado campoMinado;

	public PainelJogoFacil(CampoMinado campoMinado) {
		setBackground(Color.WHITE);
		this.campoMinado = campoMinado;
		setSize(784, 420);

		JPanel tabuleiro = new JPanel();
		tabuleiro.setBackground(Color.WHITE);

		int tamBotoes = getHeight() / campoMinado.getDificuldade().getLinhas();
		ArrayList<ArrayList<BotaoCasa>> botoes = new ArrayList<>();
		for (int i = 0; i < campoMinado.getDificuldade().getLinhas(); i++) {
			ArrayList<BotaoCasa> aux = new ArrayList<>();
			for (int j = 0; j < campoMinado.getDificuldade().getColunas(); j++) {
				aux.add(new BotaoCasa(i, j, tamBotoes, campoMinado));
				aux.get(j).setLocation(tamBotoes * i, tamBotoes * j);
				tabuleiro.add(aux.get(j));
			}
			botoes.add(aux);
		}
		tabuleiro.setLayout(null);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(185)
						.addComponent(tabuleiro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(185)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(tabuleiro, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

}
