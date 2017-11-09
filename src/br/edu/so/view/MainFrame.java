package br.edu.so.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.so.util.Imagens;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	
	public static void main(String[] args) {
		new MainFrame();
	}
	public MainFrame() {
		setTitle("Campo Minado v1.0");
		setIconImage(Imagens.getImgBomba().getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel informacoes = new JPanel();
		getContentPane().add(informacoes, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		setVisible(true);
	}

}
