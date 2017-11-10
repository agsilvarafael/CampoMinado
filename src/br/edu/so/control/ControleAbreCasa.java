package br.edu.so.control;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import br.edu.so.model.CampoMinado;
import br.edu.so.util.Imagens;
import br.edu.so.view.BotaoCasa;

public class ControleAbreCasa {

	// private Integer linha;
	// private Integer coluna;
	// private CampoMinado campoMinado;
	// private JButton botao;

	// @Override
	// public void mouseClicked(MouseEvent e) {
	// if (SwingUtilities.isLeftMouseButton(e)) {
	// System.out.println("LEFT");
	// } else if (SwingUtilities.isRightMouseButton(e)) {
	// System.out.println("RIGHT");
	// botao.setIcon(Imagens.IMG_BANDEIRA);
	// }
	// }

	public void abrirCasa(Integer linha, Integer coluna, CampoMinado campoMinado, BotaoCasa botao) {
		if (!campoMinado.isCasaAberta(linha, coluna)) {
			campoMinado.abrirCasa(linha, coluna);
			botao.setBackground(SystemColor.inactiveCaption);
			botao.setBorder(new LineBorder(Color.WHITE, 2));
			botao.setIcon(null);
			// BOMBA
			if (campoMinado.isBomba(linha, coluna)) {
				botao.setIcon(Imagens.IMG_BOMBA);
				JOptionPane.showMessageDialog(null, "Fim de Jogo!");
			}
			// VAZIO
			else if (!campoMinado.isDica(linha, coluna)) {
				botao.setText("");
			}
			// DICA
			else {
				botao.setText(campoMinado.getMatrizMapaCelula(linha, coluna).toString());
			}
			botao.removerMouseAdapter();
		}
	}
}
