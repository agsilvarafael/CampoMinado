package br.edu.so.model;

public class Mapa {

	private Integer matrizMapa[][];
	
	public Mapa(CampoMinadoDificuldades dificuldade) {
		matrizMapa = geraMatriz(dificuldade.getAltura(), dificuldade.getLargura());
	}
	
	private Integer[][] geraMatriz(int linhas, int colunas){
		Integer temp[][] = new Integer[linhas][colunas];
		return temp;
	}

	public Integer getMatrizMapaCelula(int linha, int coluna) {
		return matrizMapa[linha][coluna];
	}
	
	public void setMatrizMapaCelula(int linha, int coluna, int valor) {
		matrizMapa[linha][coluna] = valor;
	}
	
	
	
}
