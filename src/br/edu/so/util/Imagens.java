package br.edu.so.util;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Imagens {

	private static Integer ALTURA = 50;
	private static Integer LARGURA = 50;
	private static String caminho = "/br/edu/so/imgs/";

	public static ImageIcon getImgBandeira() {
		return new ImageIcon((new ImageIcon(Imagens.class.getResource(caminho + "bandeira.png"))).getImage()
				.getScaledInstance(ALTURA, LARGURA, Image.SCALE_DEFAULT));
	}

	public static ImageIcon getImgBomba() {
		return new ImageIcon((new ImageIcon(Imagens.class.getResource(caminho + "bomba.png"))).getImage()
				.getScaledInstance(ALTURA, LARGURA, Image.SCALE_DEFAULT));
	}

	public static ImageIcon getImgExplosao() {
		return new ImageIcon((new ImageIcon(Imagens.class.getResource(caminho + "explosao.png"))).getImage()
				.getScaledInstance(ALTURA, LARGURA, Image.SCALE_DEFAULT));
	}

	public static ImageIcon getImgRestart() throws IllegalArgumentException {
		return new ImageIcon((new ImageIcon(Imagens.class.getResource(caminho + "restart.png"))).getImage()
				.getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	}

}
