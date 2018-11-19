package Trabalho02.TemperaSimulada;

public class Main {

    public static void main(String[] args) {

        Problema problema = new Problema(50);
        Busca busca = new Busca(problema);

        System.out.println("\n === Estado Inicial === \n");
        System.out.println("Valor do estado : " + problema.getEstadoInicial().getValor());
        imprimir(problema.getEstadoInicial().getTabuleiro());
        
        System.out.println("\n === Tempera Simulada ==== \n");
        int temperatura = 1000;
        Estado solucao = busca.temperaSimulada(temperatura);
        System.out.println("Valor do estado : " + solucao.getValor());
        imprimir(solucao.getTabuleiro());
    }

    public static void imprimir(int[][] tabuleiro) {
        String quadradoDoTabuleiro;
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
                quadradoDoTabuleiro = (tabuleiro[linha][coluna] == 0) ? " " : "1";
                System.out.print("| " + quadradoDoTabuleiro + " ");
            }
            System.out.println("|\n");
        }
    }

}
