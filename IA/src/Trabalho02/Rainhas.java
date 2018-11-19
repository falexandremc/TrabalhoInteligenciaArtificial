package Trabalho02;

public class Rainhas {
	
	private int numColisao;
	private int tamTabuleiro;
	private int tabuleiro[];
	
	public Rainhas(int tamTabuleiro) {
		this.tamTabuleiro=tamTabuleiro;
		this.tabuleiro=new int [tamTabuleiro];
	}
	public Rainhas vizinhos() {
		//a fazer
		return null;
	}

	public int getNumColisao() {
		return numColisao;
	}

	public void setNumColisao(int numColisao) {
		this.numColisao = numColisao;
	}
	
}
