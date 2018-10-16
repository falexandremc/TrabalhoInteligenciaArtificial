
import java.util.ArrayList;
import java.util.Arrays;
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
        //System.out.println(reguaDeEntrada.toString());
        CalcularEstadoMeta();
    }

    private void CalcularEstadoMeta() {
        reguaDoEstadoMeta = new Regua(reguaDeEntrada.getN(), Arrays.copyOf(reguaDeEntrada.getRegua(),reguaDeEntrada.getSize()));
        //adiciona espaco vazio ao meio da regua
        reguaDoEstadoMeta.setI(reguaDeEntrada.getN(), '#');
        //preenche do inicio ate o meio da regua com 'B' e do final ate o meio com 'A'
        for (int i = 0; i < reguaDeEntrada.getN(); i++) {
            reguaDoEstadoMeta.setI(i, 'B');
            reguaDoEstadoMeta.setI((reguaDeEntrada.getSize() - 1) - i, 'A');
        }
    }

    public static void main(String[] args) {
        args = new String[2];
        args[0] = "4";
        args[1] = "BBAB#BAAA";
        ReguaPuzzle Game = new ReguaPuzzle(new Regua(Integer.parseInt(args[0]), args[1]));
        Regua entrada=Game.reguaDeEntrada;
        Regua meta=Game.reguaDoEstadoMeta;
        AlgoritmosDeBusca busca= new AlgoritmosDeBusca();
        Regua r= busca.BreadthFirstSearch(entrada, meta);
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        
        //System.out.println(new AlgoritmosDeBusca().DepthFirstSearch(Game.reguaDeEntrada, Game.reguaDoEstadoMeta, new HashSet<Regua>(), new ArrayList<>()).toString());
        //System.out.println(new AlgoritmosDeBusca().idaStar(Game.reguaDeEntrada, Game.reguaDoEstadoMeta).toString());
        
    }
}
