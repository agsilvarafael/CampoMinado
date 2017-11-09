package br.edu.so.model;

public enum CampoMinadoDificuldades {
	
	FACIL(9, 9, 10),
	MEDIO(16, 16, 40),
	DIFICIL(20, 24, 99);
	
	private final int altura, largura, qtdBombas;
	
	CampoMinadoDificuldades(int altura, int largura, int qtdBombas){
		this.altura = altura;
		this.largura = largura;
		this.qtdBombas = qtdBombas;
	}
	public int getAltura() {
		return altura;
	}
	public int getLargura() {
		return largura;
	}
	public int getQtdBombas() {
		return qtdBombas;
	}
	
	
}
