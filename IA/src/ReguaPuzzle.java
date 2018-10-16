
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
       System.out.println("--------- BreadthFirstSearch ---------");
        Regua r= busca.BreadthFirstSearch(entrada, meta);
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        r=busca.DepthFirstSearch(entrada, meta, new HashSet<Regua>(), new ArrayList<>());
        System.out.println(r);
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        System.out.println("--------- BestFirstSearch ---------");
        r=busca.BestFirstSearch(entrada, meta);
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        }
        System.out.println("-------- A* -------------");
        r=busca.aStar(entrada, meta);
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        System.out.println("-------- IDA* -------------");
        r=busca.idaStar(entrada, meta);
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        //System.out.println(new AlgoritmosDeBusca().idaStar(Game.reguaDeEntrada, Game.reguaDoEstadoMeta).toString());
        
    }
}
