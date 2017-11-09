package br.edu.so.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import br.edu.so.model.Mapa;
import br.edu.so.util.FonteCronometro;
import br.edu.so.util.Imagens;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Mapa mapa;

	// TODO: Trocar pontuação por quantidade de bombas
	public MainFrame(Mapa mapa) {
		this.mapa = mapa;

		setTitle("Campo Minado v1.0");
		setIconImage(Imagens.getImgBomba().getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 600));
		setSize(800, 600);
		setLocationRelativeTo(null);

		JPanel pJogo = new JPanel();
		pJogo.setMinimumSize(new Dimension(784, 420));
		FlowLayout fl_pJogo = (FlowLayout) pJogo.getLayout();
		fl_pJogo.setHgap(10);
		fl_pJogo.setVgap(0);
		pJogo.setBorder(null);
		pJogo.setBackground(Color.CYAN);

		JPanel pInfo = new JPanel();
		pInfo.setMinimumSize(new Dimension(784, 120));
		pInfo.setIgnoreRepaint(true);
		pInfo.setBackground(Color.WHITE);
		pInfo.setBorder(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pJogo, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addComponent(pInfo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pJogo, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
						.addComponent(pInfo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)));

		JLabel btnRestart = new JLabel(Imagens.getImgRestart());
		btnRestart.setIgnoreRepaint(true);
		btnRestart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRestart.setToolTipText("Novo jogo");
		btnRestart.setBackground(Color.LIGHT_GRAY);

		JLabel lblPontos = new JLabel("10000");
		lblPontos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPontos.setForeground(new Color(128, 0, 0));
		lblPontos.setFont(FonteCronometro.getFonteRelogio());
		lblPontos.setBackground(Color.BLACK);

		JLabel lblCronometro = new JLabel("00:00:0000");
		lblCronometro.setFont(FonteCronometro.getFonteRelogio());
		lblCronometro.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_pInfo = new GroupLayout(pInfo);
		gl_pInfo.setHorizontalGroup(gl_pInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pInfo.createSequentialGroup().addGap(25)
						.addComponent(lblPontos, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addGap(180).addComponent(btnRestart, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE).addGap(130)
						.addComponent(lblCronometro, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addGap(25)));
		gl_pInfo.setVerticalGroup(gl_pInfo.createParallelGroup(Alignment.TRAILING).addGroup(gl_pInfo
				.createSequentialGroup().addGap(30)
				.addGroup(gl_pInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRestart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPontos, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addComponent(lblCronometro, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
				.addGap(30)));
		pInfo.setLayout(gl_pInfo);
		getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnConfig = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfig);

		JMenuItem mntmNovoJogo = new JMenuItem("Novo Jogo");
		mntmNovoJogo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mnConfig.add(mntmNovoJogo);

		JMenuItem mntmFacil = new JMenuItem("Fácil");
		mnConfig.addSeparator();
		mnConfig.add(mntmFacil);

		JMenuItem mntmMedio = new JMenuItem("M\u00E9dio");
		mnConfig.add(mntmMedio);

		JMenuItem mntmDifcil = new JMenuItem("Dif\u00EDcil");
		mnConfig.add(mntmDifcil);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mnConfig.addSeparator();
		mnConfig.add(mntmSair);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmRegras = new JMenuItem("Regras");
		mntmRegras.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAjuda.add(mntmRegras);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);

		setVisible(true);
	}
}
