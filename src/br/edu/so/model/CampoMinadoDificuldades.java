package br.edu.so.model;

public enum CampoMinadoDificuldades {

	FACIL(9, 9, 10), MEDIO(16, 16, 40), DIFICIL(16, 30, 99);

	private final int linhas, colunas, qtdBombas;

	CampoMinadoDificuldades(int linhas, int colunas, int qtdBombas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.qtdBombas = qtdBombas;
	}

	public Integer getLinhas() {
		return linhas;
	}

	public Integer getColunas() {
		return colunas;
	}

	public Integer getQtdBombas() {
		return qtdBombas;
	}

}
