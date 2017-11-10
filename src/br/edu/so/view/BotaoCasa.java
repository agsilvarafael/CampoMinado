package br.edu.so.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import br.edu.so.control.ControleAbreCasa;
import br.edu.so.model.CampoMinado;
import br.edu.so.util.Imagens;

public class BotaoCasa extends JButton {

	private static final long serialVersionUID = 1L;

	private final Integer x, y;
	private CampoMinado campoMinado;
	private ControleAbreCasa cac;
	private Boolean marcado;
	private final MouseAdapter ma = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// LEFT
			if (SwingUtilities.isLeftMouseButton(e) && !isMarcado())
				cac.abrirCasa(x, y, campoMinado, BotaoCasa.this);
			// RIGHT
			else if (SwingUtilities.isRightMouseButton(e)) {
				setIcon(isMarcado() ? null : Imagens.IMG_BANDEIRA);
				marcado = !marcado;
			}
		}
	};

	public BotaoCasa(int x, int y, int lado, CampoMinado campoMinado) {
		this.x = x;
		this.y = y;
		this.campoMinado = campoMinado;
		this.cac = new ControleAbreCasa();
		marcado = false;
		setBackground(Color.BLACK);
		setSize(lado, lado);
		setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		this.addMouseListener(ma);
	}

	public void removerMouseAdapter() {
		this.removeMouseListener(ma);
	}

	public Boolean isMarcado() {
		return marcado;
	}

}
