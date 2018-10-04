
import java.util.Iterator;

/**
 *
 * @author Alexandre
 */
public class AlgoritmosDeBusca {
     
    private void DepthFirstSearch(int i, boolean[] visitados, Grafo espacoDeBusca) {
        visitados[i] = true;
        Iterator<Integer> car = espacoDeBusca.arestas[i].iterator();
        while (car.hasNext()) {
            int n = car.next();
            if (!visitados[n])
                DepthFirstSearch(n, visitados, espacoDeBusca);
        }
    }
}
