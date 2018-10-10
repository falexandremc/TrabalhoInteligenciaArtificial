/**
 *
 * @author Alexandre
 */
public class ReguaPuzzle {
    Regua reguaDoEstadoMeta;
    Regua reguaDeEntrada;

    public ReguaPuzzle(Regua reguaDeEntrada) {
        this.reguaDeEntrada = reguaDeEntrada;
        CalcularEstadoMeta(reguaDeEntrada);
    }

    private void CalcularEstadoMeta(Regua reguaDeEntrada1) {
        //adiciona espaco vazio ao meio da regua
        reguaDoEstadoMeta.setI(reguaDeEntrada1.getN() + 1, '#');
        //preenche do inicio ate o meio da regua com 'A' e do final ate o meio com 'B'
        for (int i = 0; i < reguaDeEntrada1.getN(); i++) {
            reguaDoEstadoMeta.setI(i, 'A');
            reguaDoEstadoMeta.setI(reguaDeEntrada1.getN() - i, 'B');
        }
    }
    
    private boolean TesteDeMeta(Regua reguaAtual) {
    	if(reguaAtual.getRegua().toString()==reguaDoEstadoMeta.getRegua().toString())
    		return true;
    	return false;
    }
}
