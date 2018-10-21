
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Alexandre
 */
public class ReguaPuzzle {

    ArrayList<Regua> reguaDoEstadoMeta;
    Regua reguaDeEntrada;

    public ReguaPuzzle(Regua reguaDeEntrada) {
        this.reguaDeEntrada = reguaDeEntrada;
        //System.out.println(reguaDeEntrada.toString());
        CalcularEstadoMeta();
    }

    private void CalcularEstadoMeta() {
    	reguaDoEstadoMeta=new ArrayList<>();
        for(int i=0;i<reguaDeEntrada.getSize();i++) {
        	Character aux[]= new Character[reguaDeEntrada.getSize()];
        	int cont=0;
        	for(int j=0;j<reguaDeEntrada.getSize();j++) {
        		if(i==j) {
        			aux[j]='#';
        		}else if(cont <reguaDeEntrada.getN() ) {
        			aux[j]='B';
        			cont++;
        		}else {
        			aux[j]='A';
        		}
        	}
        	Regua meta = new Regua(reguaDeEntrada.getN(), Arrays.copyOf(aux,aux.length));
        	reguaDoEstadoMeta.add(meta);
        }
    }

    public static void main(String[] args) {
        args = new String[2];
        args[0] = "4";
        args[1] = "BBAB#BAAA";
        ReguaPuzzle Game = new ReguaPuzzle(new Regua(Integer.parseInt(args[0]), args[1]));
        Regua entrada=Game.reguaDeEntrada;
       ArrayList<Regua> meta=Game.reguaDoEstadoMeta;
        AlgoritmosDeBusca busca= new AlgoritmosDeBusca();
       System.out.println("--------- BreadthFirstSearch ---------");
        Regua r= busca.BreadthFirstSearch(entrada, meta);
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        System.out.println("---------- DepthFirstSearch ----------------");
        r=busca.DepthFirstSearch(entrada, meta);
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        System.out.println("---------- DepthFirstSearchIteractive--------");
        r=busca.DepthFirstSearchIteractive(entrada, meta);
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
        
    }
}
