package br.edu.so.model;

public class Mapa {

	private Integer matrizMapa[][]; // Começa no 0; Matriz com as bombas, dicas e espaços vazios
	private Boolean matrizMapaAberto[][];// TRUE quando a casa for aberta/FALSE caso contrário
	public static Integer BOMBA = -1;
	public static Integer VAZIO = 0;
	private Integer casasRestantes;
	private CampoMinadoDificuldades dificuldade;

	public Mapa() {
		novoJogo(CampoMinadoDificuldades.FACIL);
	}

	public void novoJogo(CampoMinadoDificuldades dificuldade) {
		this.dificuldade = dificuldade;
		matrizMapa = geraMatrizMapa(dificuldade.getAltura(), dificuldade.getLargura());
		matrizMapaAberto = geraMapaFechado(dificuldade.getAltura(), dificuldade.getLargura());
		casasRestantes = dificuldade.getAltura() * dificuldade.getLargura();
	}

	private Integer[][] geraMatrizMapa(int linhas, int colunas) {
		Integer temp[][] = new Integer[linhas][colunas];
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				temp[i][j] = new Integer("0");
			}
		}
		return temp;
	}

	private Boolean[][] geraMapaFechado(int linhas, int colunas) {
		Boolean temp[][] = new Boolean[linhas][colunas];
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				temp[i][j] = false;
			}
		}
		return temp;
	}

	public Integer getMatrizMapaCelula(int linha, int coluna) {
		return matrizMapa[linha][coluna];
	}

	public void abrirCasa(int linha, int coluna) {
		matrizMapaAberto[linha][coluna] = true;
		casasRestantes--;
	}

	public Boolean isCasaAberta(int linha, int coluna) {
		return matrizMapaAberto[linha][coluna];
	}

	public synchronized Boolean setBomba(int linha, int coluna) {
		if (isBomba(linha, coluna)) {
			notifyAll();
			return false;
		}
		// posiciona bomba
		matrizMapa[linha][coluna] = BOMBA;

		// Incrementar dica nos vizinhos
		for (int i = linha - 1; i < linha + 2 && i < dificuldade.getAltura(); i++) {
			if (i < 0)
				continue;
			for (int j = coluna - 1; j < coluna + 2 && j < dificuldade.getLargura(); j++) {
				if (j < 0)
					continue;
				if (!isBomba(i, j)) {
					matrizMapa[i][j]++;
				}
			}
		}

		notifyAll();
		return true;
	}

	public Boolean isBomba(int linha, int coluna) {
		return matrizMapa[linha][coluna] == BOMBA;
	}

	public Boolean isVazio(int linha, int coluna) {
		return matrizMapa[linha][coluna] == VAZIO;
	}

	public Boolean isDica(int linha, int coluna) {
		return matrizMapa[linha][coluna] > VAZIO;
	}

}
