
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
        double timeInicio = System.nanoTime();
        Regua r= busca.BreadthFirstSearch(entrada, meta);
        double timeFinal = System.nanoTime();
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
        System.out.println("---------- DepthFirstSearch ----------------");
        timeInicio = System.nanoTime();
        r=busca.DepthFirstSearch(entrada, meta);
        timeFinal = System.nanoTime();
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        }
        System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
        System.out.println("---------- DepthFirstSearchIteractive--------");
        timeInicio = System.nanoTime();
        r=busca.DepthFirstSearchIteractive(entrada, meta);
        timeFinal = System.nanoTime();
        System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        System.out.println("--------- BestFirstSearch ---------");
        timeInicio = System.nanoTime();
        r=busca.BestFirstSearch(entrada, meta);
        timeFinal = System.nanoTime();
        System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        }
        System.out.println("-------- A* -------------");
        timeInicio = System.nanoTime();
        r=busca.aStar(entrada, meta);
        timeFinal = System.nanoTime();
        System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        System.out.println("-------- IDA* -------------");
        timeInicio = System.nanoTime();
        r=busca.idaStar(entrada, meta);
        timeFinal = System.nanoTime();
        System.out.println("Tempo "+ ((timeFinal - timeInicio)*0.000000001));
        while(r!= null) {
        	System.out.println(r);
        	r= r.getPredecessor();
        } 
        
    }
}
