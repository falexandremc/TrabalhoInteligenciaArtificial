package Trabalho01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Alexandre
 */
public class AlgoritmosDeBusca {

	/**
	 * Algoritmo de busca em largura
	 *
	 * @param regua Regua do estado inicial
	 * @param estadoMeta Regua do estado méta. o algoritmo para quando esse
	 * estado é alcançado
	 * @return o caminho do estado inicial até o estado meta ou NULL caso não
	 * exista uma solução
	 */
	public Regua BreadthFirstSearch(Regua regua, ArrayList<Regua> estadoMeta) {
		//conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
		HashSet<Regua> estadosVisitados = new HashSet<>();
		//lista de estados
		ArrayList<Regua> listaDeEstados = new ArrayList<>();
		//adicionando o estado inicial
		listaDeEstados.add(regua);
		estadosVisitados.add(regua);
		int estadosExpandidos = 0;
		//percorre os sucessores de cada estado visitado até não haver mais estados a visitar.
		while (!listaDeEstados.isEmpty()) {
			//removendo uma regua da lista de estados para verificar se este é meta
			Regua element = listaDeEstados.remove(0);
			//se o estado for meta retorna o estado
			for(int i=0;i<estadoMeta.size();i++) {
				if (element.equals(estadoMeta.get(i))) {
					System.out.println("Quantidade de nos " + estadosVisitados.size());
					//Verifica quantos estados foram expandidos até achar a solução
					System.out.println("Quantidade estados expandidos " + estadosExpandidos);
					System.out.println("Fator de ramificação " + (float) estadosVisitados.size() / estadosExpandidos);
					return element;
				}
			}
			//buscando os sucessores do elemento
			List<Regua> vizinhos = element.sucessores();
			estadosExpandidos++;
			//para cada sucessor
			for (int i = 0; i < vizinhos.size(); i++) {
				Regua r = vizinhos.get(i);
				//se o estado não esta nulo e nem foi visitado
				if (r != null && !estadosVisitados.contains(r)) {
					//adiciona o estado na lista de estados
					r.setProfundidade(element.getProfundidade()+1);
					r.setPredecessor(element);
					listaDeEstados.add(r);
					estadosVisitados.add(r);
				}
			}
		}
		return null;
	}

	/**
	 * Algoritmo de busca em profundidade
	 *
	 * @param regua Regua do estado inicial
	 * @param estadoMeta Regua do estado méta. o algoritmo para quando esse
	 * estado é alcançado
	 * @return o caminho do estado inicial até o estado meta ou NULL caso não
	 * exista uma solução
	 */

	public Regua DepthFirstSearch(Regua regua, ArrayList<Regua> estadoMeta) {
		//conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
		HashSet<Regua> estadosVisitados = new HashSet<>();
		//lista de estados
		ArrayList<Regua> listaDeEstados = new ArrayList<>();
		//adicionando o estado inicial
		listaDeEstados.add(regua);
		estadosVisitados.add(regua);
		int estadosExpandidos = 0;
		//percorre os sucessores de cada estado visitado até não haver mais estados a visitar.
		while (!listaDeEstados.isEmpty()) {
			//removendo uma regua da lista de estados para verificar se este é meta
			Regua element = listaDeEstados.remove(listaDeEstados.size() - 1);
			//se o estado for meta retorna o estado
			for(int i=0;i<estadoMeta.size();i++) {
				if (element.equals(estadoMeta.get(i))) {
					System.out.println("Quantidade de nos " + estadosVisitados.size());
					//Verifica quantos estados foram expandidos até achar a solução
					System.out.println("Quantidade estados expandidos " + estadosExpandidos);
					System.out.println("Fator de ramificação " + (float) estadosVisitados.size() / estadosExpandidos);
					return element;
				}
			}
			//buscando os sucessores do elemento
			List<Regua> vizinhos = element.sucessores();
			estadosExpandidos++;
			//para cada sucessor
			for (int i = 0; i < vizinhos.size(); i++) {
				Regua r = vizinhos.get(i);
				//se o estado não esta nulo e nem foi visitado
				if (r != null && !estadosVisitados.contains(r)) {
					//adiciona o estado na lista de estados
					r.setPredecessor(element);
					r.setProfundidade(element.getProfundidade()+1);
					listaDeEstados.add(r);
					estadosVisitados.add(r);
				}
			}
		}
		return null;
	}

	/**
	 * Algoritmo de busca em profundidade 
	 *
	 * @param regua Regua do estado inicial
	 * @param estadoMeta Regua do estado méta. o algoritmo para quando esse
	 * estado é alcançado
	 * @param estadosVisitados conjunto de estados já visitados. é usado para
	 * não verificar um mesmo estado mais de uma vez
	 * @param listaDeEstados lista de estados
	 * @return o caminho do estado inicial até o estado meta ou NULL caso não
	 * exista uma solução
	 */
	public Regua DepthFirstSearchIteractive(Regua regua, ArrayList<Regua> estadoMeta) {
		int profundidade = regua.getSize();
		//conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
		HashSet<Regua> estadosVisitados = new HashSet<>();
		//lista de estados
		ArrayList<Regua> listaDeEstados = new ArrayList<>();
		//adicionando o estado inicial
		listaDeEstados.add(regua);
		estadosVisitados.add(regua);
		int estadosExpandidos = 0;
		//percorre os sucessores de cada estado visitado até não haver mais estados a visitar.
		while (!listaDeEstados.isEmpty()) {
			//removendo uma regua da lista de estados para verificar se este é meta
			Regua element = listaDeEstados.remove(listaDeEstados.size() - 1);
			//se o estado for meta retorna o estado
			//System.out.println(element);
			for(int i=0; i<estadoMeta.size();i++) {
				if (element.equals(estadoMeta.get(i))) {
					System.out.println("Quantidade de nos " + estadosVisitados.size());
					//Verifica quantos estados foram expandidos até achar a solução
					System.out.println("Quantidade estados expandidos " + estadosExpandidos);
					System.out.println("Fator de ramificação " + (float) estadosVisitados.size() / estadosExpandidos);
					return element;
				}
			}
			if (element.getProfundidade() == profundidade) {
				continue;
			}
			//buscando os sucessores do elemento
			List<Regua> vizinhos = element.sucessores();
			estadosExpandidos++;
			//para cada sucessor
			for (int i = 0; i < vizinhos.size(); i++) {
				Regua r = vizinhos.get(i);
				//se o estado não esta nulo e nem foi visitado
				if (r != null && !estadosVisitados.contains(r)) {
					//adiciona o estado na lista de estados
					r.setProfundidade(element.getProfundidade() + 1);
					r.setPredecessor(element);
					listaDeEstados.add(r);
					estadosVisitados.add(r);
				}
			}
		}
		return null;

	}

	public Regua BestFirstSearch(Regua regua, ArrayList<Regua> estadoMeta) {
		//conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
		HashSet<Regua> estadosVisitados = new HashSet<Regua>();
		//lista de estados
		PriorityQueue<Regua> estados = new PriorityQueue<Regua>();
		//adicionando o estado inicial
		estados.add(regua);
		estadosVisitados.add(regua);
		int estadosExpandidos = 0;
		while (!estados.isEmpty()) {
			Regua r = estados.poll();
			for(int i=0; i<estadoMeta.size();i++) {
				if (r.equals(estadoMeta.get(i))) {
					System.out.println("Quantidade de nos " + estadosVisitados.size());
					System.out.println("Quantidade estados expandidos " + estadosExpandidos);
					System.out.println("Fator de ramificação " + (float) estadosVisitados.size() / estadosExpandidos);
					return r;
				}
			}
			//buscando os sucessores do elemento
			List<Regua> vizinhos = r.sucessores();
			estadosExpandidos++;
			//para cada sucessor
			for (int i = 0; i < vizinhos.size(); i++) {
				Regua aux = vizinhos.get(i);
				//se o estado não esta nulo e nem foi visitado
				if (aux != null && !estadosVisitados.contains(aux)) {
					//adiciona o estado na lista de estados
					aux.setPredecessor(r);
					aux.setProfundidade(r.getProfundidade()+1);
					estados.add(aux);
					estadosVisitados.add(aux);
				}
			}
		}
		return null;

	}

	public Regua aStar(Regua regua, ArrayList<Regua> estadoMeta) {
		//conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
		HashSet<Regua> estadosVisitados = new HashSet<Regua>();
		//lista de estados
		PriorityQueue<Regua> estados = new PriorityQueue<Regua>();
		//adicionando o estado inicial
		regua.calc_H();
		estados.add(regua);
		estadosVisitados.add(regua);
		int estadosExpandidos = 0;

		while (!estados.isEmpty()) {
			Regua r = estados.poll();
			for(int i=0;i<estadoMeta.size();i++) {
				if (r.equals(estadoMeta.get(i))) {
					System.out.println("Quantidade de nos " + estadosVisitados.size());
					//Verifica quantos estados foram expandidos até achar a solução
					System.out.println("Quantidade estados expandidos " + estadosExpandidos);
					System.out.println("Fator de ramificação " + (float) estadosVisitados.size() / estadosExpandidos);
					return r;
				}
			}

			//buscando os sucessores do elemento
			ArrayList<Regua> vizinhos = r.sucessores();
			estadosExpandidos++;
			//para cada sucessor
			for (int i = 0; i < vizinhos.size(); i++) {
				Regua aux = vizinhos.get(i);
				//se o estado não esta nulo e nem foi visitado
				if (aux != null && !estadosVisitados.contains(aux)) {
					// calcula h(n)
					aux.calc_H();
					//adiciona o estado na lista de estados
					aux.setPredecessor(r);
					aux.setProfundidade(r.getProfundidade()+1);
					estados.add(aux);
					estadosVisitados.add(aux);
				}
			}
		}
		return null;
	} 	

	public Regua idaStar(Regua regua, ArrayList<Regua> estadoMeta) {
		//conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
		HashSet<Regua> estadosVisitados = new HashSet<Regua>();
		//lista de estados
		PriorityQueue<Regua> estados = new PriorityQueue<Regua>();
		//adicionando o estado inicial
		regua.calc_H();
		estados.add(regua);
		estadosVisitados.add(regua);
		int estadosExpandidos = 0;
		int l = regua.getG() + regua.getH();
		while (!estados.isEmpty()) {
			Regua r = estados.poll();
			//verificar ate limite
			while (r.getG() + r.getH() <= l) {
				for(int i=0;i<estadoMeta.size();i++) {
					if (r.equals(estadoMeta.get(i))) {
						System.out.println("Quantidade de nos " + estadosVisitados.size());
						System.out.println("Quantidade estados expandidos " + estadosExpandidos);
						System.out.println("Fator de ramificação " + (float) estadosVisitados.size() / estadosExpandidos);
						return r;
					}
				}

				//buscando os sucessores do elemento
				ArrayList<Regua> vizinhos = r.sucessores();
				estadosExpandidos++;
				//para cada sucessor
				for (int i = 0; i < vizinhos.size(); i++) {
					Regua aux = vizinhos.get(i);
					//se o estado não esta nulo e nem foi visitado
					if (aux != null && !estadosVisitados.contains(aux)) {
						// calcula h(n)
						aux.calc_H();
						//adiciona o estado na lista de estados
						aux.setPredecessor(r);
						aux.setProfundidade(r.getProfundidade()+1);
						estados.add(aux);
						estadosVisitados.add(aux);
					}
				}
				r = estados.poll();
			}
			//atualiza limite
			if (r.getG() + r.getH() > l) {
				l = r.getG() + r.getH();
				estados.add(r);
			}

		}
		return null;
	}
}
