package Trabalho01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Alexandre
 */
public class ReguaPuzzle {

	ArrayList<Regua> reguaDoEstadoMeta;
	Regua reguaDeEntrada;

	public ReguaPuzzle(Regua reguaDeEntrada) {
		this.reguaDeEntrada = reguaDeEntrada;
		//System.out.println(reguaDeEntrada.toString());
		CalcularEstadoMeta();
	}
	public void imprimeCaminho(Regua r) {
		if(r.getPredecessor()== null) {
			System.out.println(r);
		}else {
			imprimeCaminho(r.getPredecessor());
			System.out.println(r);
		}

	}

	private void CalcularEstadoMeta() {
		reguaDoEstadoMeta=new ArrayList<>();
		for(int i=0;i<reguaDeEntrada.getSize();i++) {
			Character aux[]= new Character[reguaDeEntrada.getSize()];
			int cont=0;
			for(int j=0;j<reguaDeEntrada.getSize();j++) {
				if(i==j) {
					aux[j]='#';
				}else if(cont <reguaDeEntrada.getN() ) {
					aux[j]='B';
					cont++;
				}else {
					aux[j]='A';
				}
			}
			Regua meta = new Regua(reguaDeEntrada.getN(), Arrays.copyOf(aux,aux.length));
			reguaDoEstadoMeta.add(meta);
		}
	}

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		System.out.printf("Informe o nome de arquivo texto:\n");
		String nome = ler.nextLine();

		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();
			int n=Integer.parseInt(linha);
			linha = lerArq.readLine();
			System.out.println("n = "+n);
			System.out.println("Inicio = "+linha);
			ReguaPuzzle Game = new ReguaPuzzle(new Regua(n, linha));
			Regua entrada=Game.reguaDeEntrada;
			ArrayList<Regua> meta=Game.reguaDoEstadoMeta;
			AlgoritmosDeBusca busca= new AlgoritmosDeBusca();

			System.out.println("1 - IDA*");
			System.out.println("2 - A*");
			System.out.println("3 - BestFirstSearch");
			System.out.println("4 - DepthFirstSearchIteractive");
			System.out.println("5 - DepthFirstSearch");
			System.out.println("6 - BreadthFirstSearch");
			int key= Integer.parseInt(ler.nextLine()); 
			switch (key) {
			case 1:
				idaStar(Game, entrada, meta, busca);
				break;
			case 2:
				aStar(Game, entrada, meta, busca);
				break;
			case 3:
				guloso(Game, entrada, meta, busca);
				break;
			case 4:
				buscaProfundidadeIterativo(Game, entrada, meta, busca);
				break;
			case 5:
				buscaProfundidade(Game, entrada, meta, busca);
				break;
			case 6:
				buscaLargura(Game, entrada, meta, busca);
				break;
			default:
				break;
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

	}
	private static void idaStar(ReguaPuzzle Game, Regua entrada, ArrayList<Regua> meta, AlgoritmosDeBusca busca) {
		double timeInicio;
		double timeFinal;
		Regua r;
		timeInicio = System.nanoTime();
		r=busca.idaStar(entrada, meta);
		timeFinal = System.nanoTime();
		System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
		System.out.println("Nivel da solucao "+r.getProfundidade());
		Game.imprimeCaminho(r);
	}
	private static void aStar(ReguaPuzzle Game, Regua entrada, ArrayList<Regua> meta, AlgoritmosDeBusca busca) {
		double timeInicio;
		double timeFinal;
		Regua r;
		timeInicio = System.nanoTime();
		r=busca.aStar(entrada, meta);
		timeFinal = System.nanoTime();
		System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
		System.out.println("Nivel da solucao "+r.getProfundidade());
		Game.imprimeCaminho(r);
	}
	private static void guloso(ReguaPuzzle Game, Regua entrada, ArrayList<Regua> meta, AlgoritmosDeBusca busca) {
		double timeInicio;
		double timeFinal;
		Regua r;
		timeInicio = System.nanoTime();
		r=busca.BestFirstSearch(entrada, meta);
		timeFinal = System.nanoTime();
		System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
		System.out.println("Profundidade da solucao "+r.getProfundidade());
		Game.imprimeCaminho(r);
	}
	private static void buscaProfundidadeIterativo(ReguaPuzzle Game, Regua entrada, ArrayList<Regua> meta,
			AlgoritmosDeBusca busca) {
		double timeInicio;
		double timeFinal;
		Regua r;
		timeInicio = System.nanoTime();
		r=busca.DepthFirstSearchIteractive(entrada, meta);
		timeFinal = System.nanoTime();
		System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
		System.out.println("Nivel da solucao "+r.getProfundidade());
		Game.imprimeCaminho(r);
	}
	private static void buscaProfundidade(ReguaPuzzle Game, Regua entrada, ArrayList<Regua> meta,
			AlgoritmosDeBusca busca) {
		double timeInicio;
		double timeFinal;
		Regua r;
		timeInicio = System.nanoTime();
		r=busca.DepthFirstSearch(entrada, meta);
		timeFinal = System.nanoTime();
		System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
		System.out.println("Nivel da solucao "+r.getProfundidade());
		Game.imprimeCaminho(r);
	}
	private static void buscaLargura(ReguaPuzzle Game, Regua entrada, ArrayList<Regua> meta, AlgoritmosDeBusca busca) {
		double timeInicio;
		double timeFinal;
		Regua r;
		timeInicio = System.nanoTime();
		r= busca.BreadthFirstSearch(entrada, meta);
		timeFinal = System.nanoTime();
		System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
		System.out.println("Nivel da solucao "+r.getProfundidade());
		Game.imprimeCaminho(r);
	}
}
