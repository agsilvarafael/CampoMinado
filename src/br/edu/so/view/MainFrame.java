package br.edu.so.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import br.edu.so.control.ControleCronometro;
import br.edu.so.model.CampoMinado;
import br.edu.so.model.CampoMinadoDificuldades;
import br.edu.so.util.FonteCronometro;
import br.edu.so.util.Imagens;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private CampoMinado campoMinado;
	private JLabel lblBombasResstantes;
	private JLabel lblCronometro;

	// TODO: Trocar pontuação por quantidade de bombas
	public MainFrame(CampoMinado campoMinado) {
		this.campoMinado = campoMinado;

		setTitle("Campo Minado v1.0");
		setIconImage(Imagens.IMG_BOMBA.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 600));
		setSize(800, 600);
		setLocationRelativeTo(null);

		JPanel pJogo = new JPanel();
		pJogo.setMinimumSize(new Dimension(784, 420));
		pJogo.setBorder(null);
		pJogo.setBackground(Color.WHITE);

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
						.addComponent(pJogo, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
						.addComponent(pInfo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)));
		pJogo.setLayout(new BorderLayout(0, 0));

		JPanel panel = new PainelJogoFacil(campoMinado);
		pJogo.add(panel, BorderLayout.CENTER);

		JLabel btnRestart = new JLabel(Imagens.IMG_RESTART);
		btnRestart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				novoJogo();
			}
		});
		btnRestart.setIgnoreRepaint(true);
		btnRestart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRestart.setToolTipText("Novo jogo");
		btnRestart.setBackground(Color.WHITE);

		lblBombasResstantes = new JLabel("10");
		lblBombasResstantes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBombasResstantes.setForeground(new Color(128, 0, 0));
		lblBombasResstantes.setFont(FonteCronometro.getFonteRelogio());
		lblBombasResstantes.setBackground(Color.BLACK);

		lblCronometro = new JLabel("00:00");
		lblCronometro.setFont(FonteCronometro.getFonteRelogio());
		lblCronometro.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_pInfo = new GroupLayout(pInfo);
		gl_pInfo.setHorizontalGroup(gl_pInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pInfo.createSequentialGroup().addGap(25)
						.addComponent(lblBombasResstantes, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addGap(180).addComponent(btnRestart, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE).addGap(130)
						.addComponent(lblCronometro, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addGap(25)));
		gl_pInfo.setVerticalGroup(gl_pInfo.createParallelGroup(Alignment.TRAILING).addGroup(gl_pInfo
				.createSequentialGroup().addGap(15)
				.addGroup(gl_pInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRestart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblBombasResstantes, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addComponent(lblCronometro, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
				.addGap(15)));
		pInfo.setLayout(gl_pInfo);
		getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnConfig = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfig);

		JMenuItem mntmNovoJogo = new JMenuItem("Novo Jogo");
		mntmNovoJogo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mntmNovoJogo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				novoJogo();
			}
		});
		mnConfig.add(mntmNovoJogo);

		JMenuItem mntmFacil = new JMenuItem("Fácil");
		mntmFacil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				campoMinado.setDificuldade(CampoMinadoDificuldades.FACIL);
			}
		});
		mnConfig.addSeparator();
		mnConfig.add(mntmFacil);

		JMenuItem mntmMedio = new JMenuItem("M\u00E9dio");
		mntmMedio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				campoMinado.setDificuldade(CampoMinadoDificuldades.MEDIO);
			}
		});
		mnConfig.add(mntmMedio);

		JMenuItem mntmDifcil = new JMenuItem("Dif\u00EDcil");
		mntmDifcil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				campoMinado.setDificuldade(CampoMinadoDificuldades.DIFICIL);
			}
		});
		mnConfig.add(mntmDifcil);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
			}
		});
		mnConfig.addSeparator();
		mnConfig.add(mntmSair);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmRegras = new JMenuItem("Regras");
		mntmRegras.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmRegras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "O TABULEIRO\n" + ">>> Iniciante: 81 quadrados e 10 minas.\n"
						+ ">>> Intermediário: 256 quadrados e 40 minas.\n" + ">>> Avançado: 480 quadrados e 99 minas.\n"
						+ "COMO JOGAR\n" + ">>> Se você descobrir uma mina, o jogo acaba.\n"
						+ ">>> Se descobrir um quadrado vazio, o jogo continua.\n"
						+ ">>> Se aparecer um número, ele informará quantas minas estão escondidas nos oito quadrados que o cercam. Você usa essa informação para deduzir em que quadrados próximos é seguro clicar.");
			}
		});
		mnAjuda.add(mntmRegras);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Feito por Jerônimo Hermano e Rafael Araujo para a disciplina de SO do curso de Ciências da Computação do IFB-Taguatinga.");
			}
		});
		mnAjuda.add(mntmSobre);

		setVisible(true);
	}

	public JLabel getLblBombasResstantes() {
		return lblBombasResstantes;
	}

	public JLabel getLblCronometro() {
		return lblCronometro;
	}

	private void novoJogo() {
		campoMinado.novoJogo();
		ControleCronometro.reiniciarCronometro(this);
		lblBombasResstantes.setText(campoMinado.getDificuldade().getQtdBombas().toString());
	}

}
