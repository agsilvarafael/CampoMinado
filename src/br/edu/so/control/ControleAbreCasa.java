package br.edu.so.control;

import java.awt.Color;
import java.awt.SystemColor;

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

	public void abrirCasaCompleto(Integer linha, Integer coluna, CampoMinado campoMinado, BotaoCasa botao) {
		if (!campoMinado.isCasaAberta(linha, coluna)) {
			campoMinado.abrirCasa(linha, coluna);
			botao.setBackground(SystemColor.inactiveCaption);
			botao.setBorder(new LineBorder(Color.WHITE, 2));
			botao.setIcon(null);
			// BOMBA
			if (campoMinado.isBomba(linha, coluna)) {
				botao.setIcon(Imagens.IMG_BOMBA);
				campoMinado.fimJogo(false); 
			}
			// VAZIO
			else if (!campoMinado.isDica(linha, coluna)) {
				botao.setText("");

				//Testar se acabou
				if(campoMinado.getDificuldade().getQtdBombas() == campoMinado.getCasasRestantes())
					campoMinado.fimJogo(true); 
			}
			// DICA
			else {
				botao.setText(campoMinado.getMatrizMapaCelula(linha, coluna).toString());
				
				//TODO:Precisa chamar a thread para abrir as casas vazias 
				// mas falta passar o mainframe
				//new ThreadAbrirCasasVazias(campoMinado, linha, coluna, this, mainFrame)
				
				//Testar se acabou
				if(campoMinado.getDificuldade().getQtdBombas() == campoMinado.getCasasRestantes())
					campoMinado.fimJogo(true); 
			}
			botao.removerMouseAdapter();
		}
	}

	public void abrirCasaSimples(Integer linha, Integer coluna, CampoMinado campoMinado, BotaoCasa botao) {
		if (!campoMinado.isCasaAberta(linha, coluna) && !campoMinado.isBomba(linha, coluna)) {
			campoMinado.abrirCasa(linha, coluna);
			botao.setBackground(SystemColor.inactiveCaption);
			botao.setBorder(new LineBorder(Color.WHITE, 2));
			botao.setIcon(null);
			// VAZIO
			if (!campoMinado.isDica(linha, coluna)) {
				botao.setText("");
			}
			// DICA
			else {
				botao.setText(campoMinado.getMatrizMapaCelula(linha, coluna).toString());
			}
			botao.removerMouseAdapter();
			
			//Testar se acabou
			if(campoMinado.getDificuldade().getQtdBombas() == campoMinado.getCasasRestantes())
				campoMinado.fimJogo(true); 
		}
	}
}
