package Trabalho02.TemperaSimulada;

import util.ConsoleColors;

public class Main {

    public static void main(String[] args) {

        Problema problema = new Problema(8);
        Busca busca = new Busca(problema);

        System.out.println("\n === Estado Inicial === \n");
        System.out.println("Valor do estado : " + problema.getEstadoInicial().getValor());
        imprimir(problema.getEstadoInicial().getTabuleiro());
        
        System.out.println("\n === Tempera Simulada === \n");
        int temperatura = 1000;
        Estado solucao = busca.temperaSimulada(temperatura);
        System.out.println("Valor do estado : " + solucao.getValor());
        imprimir(solucao.getTabuleiro());
    }

    public static void imprimir(int[][] tabuleiro) {
        String quadradoDoTabuleiro;
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
                quadradoDoTabuleiro = (tabuleiro[linha][coluna] == 0) ? " " : "¥";
                System.out.print(((linha%2==0&&coluna%2!=0||coluna%2==0&&linha%2!=0)?ConsoleColors.RED_BACKGROUND:ConsoleColors.CYAN_BACKGROUND)+" "+quadradoDoTabuleiro+" "+ConsoleColors.RESET);
            }
            System.out.println("");
        }
    }

}
