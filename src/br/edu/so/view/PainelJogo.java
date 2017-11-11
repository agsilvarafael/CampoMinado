package br.edu.so.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import br.edu.so.model.CampoMinado;

public class PainelJogo extends JPanel {

	private CampoMinado campoMinado;
	private ArrayList<ArrayList<BotaoCasa>> botoes;

	public PainelJogo(CampoMinado campoMinado) {
		setBackground(Color.WHITE);
		this.campoMinado = campoMinado;
		setSize(784, 420);
		setLayout(null);

		int tamBotoes = getHeight() / campoMinado.getDificuldade().getLinhas();
		botoes = new ArrayList<>();
		for (int i = 0; i < campoMinado.getDificuldade().getLinhas(); i++) {
			ArrayList<BotaoCasa> aux = new ArrayList<>();
			for (int j = 0; j < campoMinado.getDificuldade().getColunas(); j++) {
				aux.add(new BotaoCasa(i, j, tamBotoes, campoMinado));
				add(aux.get(j));
			}
			botoes.add(aux);
		}
		repaint();
	}

	public BotaoCasa getBotao(int linha, int coluna) {
		return botoes.get(linha).get(coluna);
	}

	@Override
	public void repaint() {
		if (botoes != null && botoes.size() > 0) {
			int tamBotoes = (getHeight() - 10) / campoMinado.getDificuldade().getLinhas();
			int bordaEsquerda = (getWidth() - tamBotoes * campoMinado.getDificuldade().getColunas()) / 2;
			for (int i = 0; i < campoMinado.getDificuldade().getLinhas(); i++) {
				for (int j = 0; j < campoMinado.getDificuldade().getColunas(); j++) {
					getBotao(i, j).setBounds(bordaEsquerda + tamBotoes * j, 5 + tamBotoes * i, tamBotoes, tamBotoes);
				}
			}
		}
		super.repaint();
	}
}
