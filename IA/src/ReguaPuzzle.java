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
        reguaDoEstadoMeta = new Regua(reguaDeEntrada.getN(), new Character[reguaDeEntrada.getSize()]);
        //adiciona espaco vazio ao meio da regua
        reguaDoEstadoMeta.setI(reguaDeEntrada.getN() + 1, '#');
        //preenche do inicio ate o meio da regua com 'A' e do final ate o meio com 'B'
        for (int i = 0; i < reguaDeEntrada.getN(); i++) {
            reguaDoEstadoMeta.setI(i, 'A');
            reguaDoEstadoMeta.setI(reguaDeEntrada.getN() - i, 'B');
        }
    }
    public static void main(String[] args) {
        args = new String[2];
        args[0] = "2";
        args[1] = "AB#BA";
        ReguaPuzzle Game = new ReguaPuzzle(new Regua(Integer.parseInt(args[0]), args[1]));
        System.out.println(new AlgoritmosDeBusca().BreadthFirstSearch(Game.reguaDeEntrada, Game.reguaDoEstadoMeta).toString());
    }
}
