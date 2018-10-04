
import java.util.Iterator;

/**
 *
 * @author Alexandre
 */
public class AlgoritmosDeBusca {
     
    private void DepthFirstSearch(int i, boolean[] visitados, Grafo espacoDeBusca) {
        //sinalizando que o vertice i foi visitado
        visitados[i] = true;
        //carregando lista de vertices adjacentes a i
        Iterator<Integer> listaDeAdjacentes = espacoDeBusca.arestas[i].iterator();
        //enquanto houver vertices adjacentes ao vertice i
        while (listaDeAdjacentes.hasNext()) {
            //pega o proximo vertice da lista de adjacencia
            int n = listaDeAdjacentes.next();
            //e visita este vertice caso ainda não tenha sido visitado
            if (!visitados[n])
                DepthFirstSearch(n, visitados, espacoDeBusca);
        }
    }
}
