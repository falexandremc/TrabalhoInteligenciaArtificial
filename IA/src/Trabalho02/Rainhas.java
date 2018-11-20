package Trabalho02;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

import Trabalho01.Regua;

public class Rainhas implements Comparable<Rainhas>{
	
	private int numColisao;
	private int tamTabuleiro;
	private int tabuleiro[];
	private int diagonal[];
	private int diagonalSegun[];
	
	public Rainhas(int tamTabuleiro) {
		this.setTamTabuleiro(tamTabuleiro);
		this.tabuleiro=new int [tamTabuleiro];
		this.diagonal=new int [tamTabuleiro];
		this.diagonalSegun=new int [tamTabuleiro];
		this.numColisao=0;
	}
	public Rainhas(int tamTabuleiro,int tabuleiro[]) {
		this.setTamTabuleiro(tamTabuleiro);
		this.tabuleiro=tabuleiro;
		this.diagonal=new int [tamTabuleiro];
		this.diagonalSegun=new int [tamTabuleiro];
		this.numColisao=0;
	}
	public Rainhas vizinho() {
		PriorityQueue<Rainhas> estados = new PriorityQueue<Rainhas>();
		for(int i=0;i<this.tamTabuleiro;i++) {
			for(int j=0;j<this.tamTabuleiro;j++){
				if(tabuleiro[i]==j) {
					continue;
				}else {
					int aux[]=Arrays.copyOf(tabuleiro, tamTabuleiro);
					aux[i]=j;
					Rainhas r= new Rainhas(tamTabuleiro, aux);
					r.atualizaDiagonais();
					r.calculaNumColisao();
					estados.add(r);
				}
			}
		}
		return estados.poll();
	}
	
	public static Rainhas rainhaAleatoria(int tam) {
		Rainhas r= new Rainhas(tam);
		int tabuleiro[]= new int[tam];
		Random rand = new Random();
		for(int i=0;i<tam;i++) {
			tabuleiro[i]=rand.nextInt(tam);
		}
		
		r.setTabuleiro(tabuleiro);
		r.atualizaDiagonais();
		r.calculaNumColisao();
		return r;
	}
	
	public int getNumColisao() {
		return numColisao;
	}

	public void calculaNumColisao() {
		int cont=0;
		this.numColisao=0;
		for(int i=0;i<this.tamTabuleiro;i++) {
			for(int j=i+1;j<this.tamTabuleiro;j++){
				if(tabuleiro[i]==tabuleiro[j] || diagonal[i]==diagonal[j] || diagonalSegun[i]==diagonalSegun[j]) {
					cont++;
				}
			}
		}
		this.numColisao=cont;
		
	}
	public void atualizaDiagonais() {
		for(int i=0;i<tamTabuleiro;i++) {
			diagonal[i]=tabuleiro[i]-i;
			diagonalSegun[i]=tabuleiro[i]+i;
		}
		
	}
	public void imprime() {
		for(int i=0;i<tamTabuleiro;i++) {
			System.out.print(" "+tabuleiro[i]);
		}
		System.out.println();
	}
	public int getTamTabuleiro() {
		return tamTabuleiro;
	}
	public void setTamTabuleiro(int tamTabuleiro) {
		this.tamTabuleiro = tamTabuleiro;
	}
	public int[] getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(int[] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public int[] getDiagonal() {
		return diagonal;
	}
	public void setDiagonal(int[] diagonal) {
		this.diagonal = diagonal;
	}
	public int[] getDiagonalSegun() {
		return diagonalSegun;
	}
	public void setDiagonalSegun(int[] diagonalSegun) {
		this.diagonalSegun = diagonalSegun;
	}
	
	@Override
	public int compareTo(Rainhas o) {
		if (this.numColisao > o.getNumColisao()) {
			return 1;
		} else if (this.numColisao < o.getNumColisao()) {
			return -1;
		} else {
			return 0;
		}
	}
}
