
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
    public Regua BreadthFirstSearch(Regua regua, Regua estadoMeta) {
        //conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
        HashSet<Regua> estadosVisitados = new HashSet<>();
        //lista de estados
        ArrayList<Regua> listaDeEstados = new ArrayList<>();
        //adicionando o estado inicial
        listaDeEstados.add(regua);
        estadosVisitados.add(regua);
        //percorre os sucessores de cada estado visitado até não haver mais estados a visitar.
        while (!listaDeEstados.isEmpty()) {
            //removendo uma regua da lista de estados para verificar se este é meta
            Regua element = listaDeEstados.remove(0);
            //se o estado for meta retorna o estado
            if (element.equals(estadoMeta)) {
            	System.out.println("Quantidade de nos "+ estadosVisitados.size());
                return element;
            }
            //buscando os sucessores do elemento
            List<Regua> vizinhos = element.sucessores();
            //para cada sucessor
            for (int i = 0; i < vizinhos.size(); i++) {
                Regua r = vizinhos.get(i);
                //se o estado não esta nulo e nem foi visitado
                if (r != null && !estadosVisitados.contains(r)) {
                    //adiciona o estado na lista de estados
                    r.setPredecessor(element);
                    listaDeEstados.add(r);
                    estadosVisitados.add(r);
                }
            }
        }
        return null;
    }

    /**
     * Algoritmo de busca em profundidade recursiva
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
    public Regua DepthFirstSearch(Regua regua, Regua estadoMeta, HashSet<Regua> estadosVisitados, ArrayList<Regua> listaDeEstados) {
        //CASO BASE -- se o estado for meta retorna o estado
        if (regua.equals(estadoMeta)) {
            return regua;
        }
        //adicionando o estado inicial
        listaDeEstados.add(regua);
        //buscando os sucessores da regua
        Iterator<Regua> reguas = listaDeEstados.remove(0).sucessores().iterator();
        //enquanto o estado possuir sucessores
        while (reguas.hasNext()) {
            Regua r = reguas.next();
            //visita o proximo estado sucessor se este ja não foi visitado
            if (r != null && !estadosVisitados.contains(r)) {
                estadosVisitados.add(r);
                DepthFirstSearch(r, estadoMeta, estadosVisitados, listaDeEstados);
            }
        }
        return null;
    }

    /**
     * Algoritmo de busca em profundidade recursiva
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
    public Regua DepthFirstSearchIteractive(Regua regua, Regua estadoMeta, HashSet<Regua> estadosVisitados, ArrayList<Regua> listaDeEstados, int profundidade) {
        //CASO BASE -- se o estado for meta retorna o estado
        if (regua.equals(estadoMeta)) {
            return regua;
        }
        int profundidadeAtual=1;
        //adicionando o estado inicial
        listaDeEstados.add(regua);
        //buscando os sucessores da regua
        Iterator<Regua> reguas = listaDeEstados.remove(0).sucessores().iterator();
        //enquanto o estado possuir sucessores
        while (reguas.hasNext() && profundidadeAtual<=profundidade) {
            Regua r = reguas.next();
            //visita o proximo estado sucessor se este ja não foi visitado
            if (r != null && !estadosVisitados.contains(r)) {
                estadosVisitados.add(r);
            }
            if(estadosVisitados.contains(r)){
                
            }
            profundidadeAtual=profundidadeAtual+1;
        }
        return null;
    }
    
    public Regua  BestFirstSearch(Regua regua, Regua estadoMeta) {
    	//conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
        HashSet<Regua> estadosVisitados = new HashSet<Regua>();
        //lista de estados
        PriorityQueue<Regua> estados = new PriorityQueue<Regua>();
        //adicionando o estado inicial
        estados.add(regua);
        estadosVisitados.add(regua);
        
        while(!estados.isEmpty()) {
        	Regua r= estados.poll();
        	if (regua.equals(estadoMeta)) {
                return regua;
            }
        	//buscando os sucessores do elemento
            List<Regua> vizinhos = r.sucessores();
            //para cada sucessor
            for (int i = 0; i < vizinhos.size(); i++) {
                Regua aux = vizinhos.get(i);
                //se o estado não esta nulo e nem foi visitado
                if (aux != null && !estadosVisitados.contains(r)) {
                    //adiciona o estado na lista de estados
                    estados.add(r);
                    estadosVisitados.add(r);
                }
            }
        }
		return null;
        
    }
    public Regua aStar(Regua regua, Regua estadoMeta) {
    	//conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
        HashSet<Regua> estadosVisitados = new HashSet<Regua>();
        //lista de estados
        PriorityQueue<Regua> estados = new PriorityQueue<Regua>();
        //adicionando o estado inicial
        regua.calc_H();
        estados.add(regua);
        estadosVisitados.add(regua);
        
        while(!estados.isEmpty()) {
        	Regua r= estados.poll();
        	if (regua.equals(estadoMeta)) {
                return regua;
            }
        	//buscando os sucessores do elemento
            List<Regua> vizinhos = r.sucessores();
            //para cada sucessor
            for (int i = 0; i < vizinhos.size(); i++) {
                Regua aux = vizinhos.get(i);
                //se o estado não esta nulo e nem foi visitado
                if (aux != null && !estadosVisitados.contains(r)) {
                    // calcula h(n)
                	aux.calc_H();
                	//adiciona o estado na lista de estados
                	estados.add(r);
                    estadosVisitados.add(r);
                }
            }
        }
		return null;
    }
    public Regua idaStar(Regua regua, Regua estadoMeta) {
    	//conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
        HashSet<Regua> estadosVisitados = new HashSet<Regua>();
        //lista de estados
        PriorityQueue<Regua> estados = new PriorityQueue<Regua>();
        //adicionando o estado inicial
        regua.calc_H();
        estados.add(regua);
        estadosVisitados.add(regua);
        int l=regua.getG()+ regua.getH();
        while(!estados.isEmpty()) {
        	Regua r= estados.poll();
        	//verificar ate limite
        	while(r.getG()+r.getH()<=l) {
        		if (regua.equals(estadoMeta)) {
                    return regua;
                }
            	//buscando os sucessores do elemento
                List<Regua> vizinhos = r.sucessores();
                //para cada sucessor
                for (int i = 0; i < vizinhos.size(); i++) {
                    Regua aux = vizinhos.get(i);
                    //se o estado não esta nulo e nem foi visitado
                    if (aux != null && !estadosVisitados.contains(r)) {
                        // calcula h(n)
                    	aux.calc_H();
                    	//adiciona o estado na lista de estados
                    	estados.add(r);
                        estadosVisitados.add(r);
                    }
                }
                r=estados.poll();
        	}
        	//atualiza limite
        	if(r.getG()+r.getH()>l) {
        		l=r.getG()+r.getH();
        		estados.add(r);
        	}
        	
        }
		return null;
    }
}
