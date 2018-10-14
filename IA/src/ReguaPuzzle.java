
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Alexandre
 */
public class ReguaPuzzle {

    Regua reguaDoEstadoMeta;
    Regua reguaDeEntrada;

    public ReguaPuzzle(Regua reguaDeEntrada) {
        this.reguaDeEntrada = reguaDeEntrada;
        CalcularEstadoMeta();
    }

    private void CalcularEstadoMeta() {
        reguaDoEstadoMeta = new Regua(reguaDeEntrada.getN(), reguaDeEntrada.getRegua());
        //adiciona espaco vazio ao meio da regua
        reguaDoEstadoMeta.setI(reguaDeEntrada.getN(), '#');
        //preenche do inicio ate o meio da regua com 'A' e do final ate o meio com 'B'
        for (int i = 0; i < reguaDeEntrada.getN(); i++) {
            reguaDoEstadoMeta.setI(i, 'A');
            reguaDoEstadoMeta.setI((reguaDeEntrada.getSize() - 1) - i, 'B');
        }
    }

    public static void main(String[] args) {
        args = new String[2];
        args[0] = "4";
        args[1] = "BBAB#BAAA";
        ReguaPuzzle Game = new ReguaPuzzle(new Regua(Integer.parseInt(args[0]), args[1]));
        //System.out.println(new AlgoritmosDeBusca().BreadthFirstSearch(Game.reguaDeEntrada, Game.reguaDoEstadoMeta).toString());
        //System.out.println(new AlgoritmosDeBusca().DepthFirstSearch(Game.reguaDeEntrada, Game.reguaDoEstadoMeta, new HashSet<Regua>(), new ArrayList<>()).toString());
        System.out.println(new AlgoritmosDeBusca().idaStar(Game.reguaDeEntrada, Game.reguaDoEstadoMeta).toString());
        
    }
}
