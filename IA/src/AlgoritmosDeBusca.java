
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Alexandre
 */
public class AlgoritmosDeBusca {
	
	// conjunto de estados
	private HashSet<Regua> h = new HashSet<Regua>(); 
	// estados da busca
	private ArrayList<Regua> listaDeEstados;

    /**
     * Algoritmo de busca em largura
     * @param regua Regua do estado inicial
     * @param estadoMeta Regua do estado méta. o algoritmo para quando esse estado é alcançado
     * @return o caminho do estado inicial até o estado meta ou NULL caso não exista uma solução
     */
    public Regua BreadthFirstSearch(Regua regua, Regua estadoMeta) {
    	h= new HashSet<>();
    	//lista de estados
       listaDeEstados = new ArrayList<Regua>();
        //adicionando o estado inicial
        listaDeEstados.add(regua);
        h.add(regua);
        //percorre os sucessores de cada estado visitado até não haver mais estados a visitar.
        while (!listaDeEstados.isEmpty()) {
            //removendo uma regua da lista de estados para verificar se este é meta
            Regua element = listaDeEstados.remove(0);
            System.out.print(Arrays.toString(element.getRegua()));
            //se o estado for meta retorna o estado
            if(element.equals(estadoMeta))
                return element;
            //buscando os sucessores do elemento
            List<Regua> vizinhos = element.sucessores();
            //para cada sucessor
            for (int i = 0; i < vizinhos.size(); i++) {
                Regua r = vizinhos.get(i);
                //se o estado não esta nulo e nem foi visitado
                if (r != null && !h.contains(r)) {
                    //adiciona o estado na lista de estados
                    listaDeEstados.add(r);
                    //e seta o estado como visitado
                    r.visitado = true;
                }
            }
        }
        return null;
    }
    
    public Regua buscaProfundidade(Regua regua, Regua estadoMeta) {
    	//lista de estados
        listaDeEstados = new ArrayList<Regua>();
         //adicionando o estado inicial
         listaDeEstados.add(regua);
         
         
         while(!listaDeEstados.isEmpty()) {
        	 
         }
    }
    
}
