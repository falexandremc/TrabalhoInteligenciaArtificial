
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

    /**
     * Algoritmo de busca em largura
     * @param regua Regua do estado inicial
     * @param estadoMeta Regua do estado méta. o algoritmo para quando esse estado é alcançado
     * @return o caminho do estado inicial até o estado meta ou NULL caso não exista uma solução
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
            if(element.equals(estadoMeta))
                return element;
            //buscando os sucessores do elemento
            List<Regua> vizinhos = element.sucessores();
            //para cada sucessor
            for (int i = 0; i < vizinhos.size(); i++) {
                Regua r = vizinhos.get(i);
                //se o estado não esta nulo e nem foi visitado
                if (r != null && !estadosVisitados.contains(r)) {
                    //adiciona o estado na lista de estados
                    listaDeEstados.add(r);
                    estadosVisitados.add(r);
                }
            }
        }
        return null;
    }
    
    /**
     * Algoritmo de busca em profundidade recursiva
     * @param regua Regua do estado inicial
     * @param estadoMeta Regua do estado méta. o algoritmo para quando esse estado é alcançado
     * @param estadosVisitados conjunto de estados já visitados. é usado para não verificar um mesmo estado mais de uma vez
     * @param listaDeEstados lista de estados
     * @return o caminho do estado inicial até o estado meta ou NULL caso não exista uma solução
     */
    private Regua DepthFirstSearch(Regua regua, Regua estadoMeta, HashSet<Regua> estadosVisitados,ArrayList<Regua> listaDeEstados) {
        //CASO BASE -- se o estado for meta retorna o estado
        if(regua.equals(estadoMeta))
            return regua;
        //adicionando o estado inicial
        listaDeEstados.add(regua);
        //buscando os sucessores da regua
        Iterator<Regua> reguas = listaDeEstados.remove(0).sucessores().iterator();
        //enquanto o estado possuir sucessores
        while (reguas.hasNext()) {
            Regua r = reguas.next();
            //visita o proximo estado sucessor se este ja não foi visitado
            if (r != null && !estadosVisitados.contains(r)){
                estadosVisitados.add(r);
                DepthFirstSearch(r, estadoMeta, estadosVisitados, listaDeEstados);
            }
        }
        return null;
    }
    
}
