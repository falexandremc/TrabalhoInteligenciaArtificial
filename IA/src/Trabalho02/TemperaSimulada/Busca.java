package Trabalho02.TemperaSimulada;

public class Busca {

    private final Problema problema;

    public Busca(Problema problema) {
        this.problema = problema;
    }
    /**
    *@param temp Temperatura
    *@return Estado no qual existe poucas ou nenhuma colisão entre rainhas
    */
    public Estado temperaSimulada(double temp) {

        Estado corrente = problema.getEstadoInicial();
        int passos = 0;
        
        while (corrente.getValor() != 0 && passos < 1000) {
            for (double temperatura = temp; (temperatura > 0) && (corrente.getValor() != 0); temperatura--) {
                Estado vizinho = problema.vizinho(corrente.getTabuleiro());
                double delta = corrente.getValor() - vizinho.getValor();
                double probabilidade = Math.exp(delta / temperatura);

                if (delta > 0) 
                    corrente = vizinho;
                else if (Math.random() <= probabilidade)
                    corrente = vizinho;
                
                passos++;
            }
        }
        System.out.println("Passos " + passos);
        return corrente;
    }
}
