

import java.util.LinkedList;
import org.graphstream.graph.EdgeRejectedException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.implementations.SingleGraph;

/**
 * @author falexandremc
 */
public class Grafo {
    public Graph graph = new SingleGraph("Grafo");
    //o atributo consiste em uma lista de adjacencia de vertices. cada vertice do tipo LindedList armazena uma sequencia de outros vertices do tipo Integer a qual esta conectado
    public LinkedList<Integer> arestas[];
    //quantidade de vertices do grafo
    public int vertice;
    
    /**
     * @param v quantidade de vertices do grafo
     */
    public Grafo(int v) {
        vertice = v;
        arestas = new LinkedList[v];
        for (int i = 0; i < vertice; i++){
            arestas[i] = new LinkedList();
            graph.addNode(String.valueOf(i));
        }
    }
    /**
     * Método inclui uma aresta não direcionada no grafo
     * @param u vertice do grafo que junto com o vertice v forma uma aresta
     * @param v vertice do grafo que junto com o vertice u forma uma aresta
    */
    public void addAresta(int u, int v) {
        arestas[u].add(v);
        arestas[v].add(u);
        try{
            graph.addEdge( String.valueOf(u)+String.valueOf(v), String.valueOf(u), String.valueOf(v) );  
        }catch(EdgeRejectedException|IdAlreadyInUseException e){}
        graph.getNode(graph.getNodeCount()-1).addAttribute("ui.label", graph.getNodeCount()-1);
        
    }
    /**
     * Método exclui uma aresta não direcionada que pertence ao grafo
     * @param u vertice do grafo que junto com o vertice v forma uma aresta
     * @param v vertice do grafo que junto com o vertice u forma uma aresta
    */
    public void delAresta(Integer u, Integer v) {
        arestas[u].remove(v);
        arestas[v].remove(u);
    }
    /**
     * Método inclui uma aresta direcionada no grafo
     * @param u vertice do grafo que junto com o vertice v forma uma aresta
     * @param v vertice do grafo que junto com o vertice u forma uma aresta
    */
    public void addArestaD(int u,int v){
        arestas[u].add(v);
    }
    /**
     * Método exclui uma aresta direcionada que pertence ao grafo
     * @param curr_v vertice do grafo que junto com o vertice next_v forma uma aresta direcionada
     * @param next_v vertice do grafo que junto com o vertice curr_v forma uma aresta direcionada
    */
    public void delArestaD(int curr_v, int next_v) {
        arestas[curr_v].remove(new Integer(next_v));
    }
}
