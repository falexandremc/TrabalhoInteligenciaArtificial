
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
        //lista de estados
       listaDeEstados = new ArrayList<Regua>();
        //adicionando o estado inicial
        listaDeEstados.add(regua);
        //marcando o estado inicial como visitado
        regua.visitado = true;
        //percorre os sucessores de cada estado até não haver mais estados a visitar.
        while (!listaDeEstados.isEmpty()) {
            //removendo uma regua da lista de estados para verificar se este é meta
            Regua elemento = listaDeEstados.remove();
            System.out.print(Arrays.toString(elemento.getRegua()));
            //se o estado for meta retorna o estado
            if(elemento.equals(estadoMeta))
                return elemento;
            //buscando os sucessores do elemento
            List<Regua> vizinhos = elemento.sucessores();
            //para cada sucessor
            for (int i = 0; i < vizinhos.size(); i++) {
                Regua r = vizinhos.get(i);
                //se o estado não esta nulo e nem foi visitado
                if (r != null && !r.visitado) {
                    //adiciona o estado na lista de estados
                    listaDeEstados.add(r);
                    //e seta o estado como visitado
                    r.visitado = true;
                }
            }
        }
        return null;
    }
    /**
     * Algoritmo de busca em profundidade recursiva
     * @param regua Regua do estado inicial
     * @param estadoMeta Regua do estado méta. o algoritmo para quando esse estado é alcançado
     * @return o caminho do estado inicial até o estado meta ou NULL caso não exista uma solução
     */
    private Regua DepthFirstSearch(Regua regua, Regua estadoMeta) {
        //CASO BASE -- se o estado for meta retorna o estado
        if(regua.equals(estadoMeta))
            return regua;
        //lista de estados
        Queue<Regua> listaDeEstados = new LinkedList<>();
        //adicionando o estado inicial
        listaDeEstados.add(regua);
        //marcando o estado inicial como visitado
        regua.visitado = true;
        //buscando os sucessores da regua
        Iterator<Regua> reguas = listaDeEstados.remove().sucessores().iterator();
        //enquanto o estado possuir sucessores
        while (reguas.hasNext()) {
            Regua r = reguas.next();
            //visita o proximo estado sucessor se este ainda não foi visitado
            if (!r.visitado)
                DepthFirstSearch(r, estadoMeta);
        }
        return null;
    }

}
