package Trabalho02.TemperaSimulada;

import java.util.ArrayList;
import java.util.Collections;

public class ProblemaDasNrainhas {

    private Estado estadoInicial;

    public ProblemaDasNrainhas(int n) {
        int[][] TabuleiroInicial = criaTabuleiroAleatorio(n);
        estadoInicial = new Estado(TabuleiroInicial, calculaValor(TabuleiroInicial));
    }

    public Estado vizinho(int[][] tabuleiro) {
        ArrayList<Estado> sucessores = new ArrayList<Estado>();
        Estado resultado = null;

        for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
            int[][] copiaTabuleiro = clonaMatriz(tabuleiro);
            int posLinha = 0, posColuna = 0;
            /* procura pela rainha na coluna */
            for (int linha = 0; linha < tabuleiro.length; linha++) {

                if (copiaTabuleiro[linha][coluna] == 1) {
                    /* remove a rainha da posicao [linha][coluna] */
                    copiaTabuleiro[linha][coluna] = 0;

                    posLinha = linha;
                    posColuna = coluna;

                    break;
                }
            }

            for (int linha = 0; linha < tabuleiro.length; linha++) {
                if ((linha != posLinha) || (coluna != posColuna)) {
                    /* move a rainha para a posicao [linha][coluna] */
                    copiaTabuleiro[linha][coluna] = 1;

                    int[][] novaMatriz = clonaMatriz(copiaTabuleiro);
                    Estado sucessor = new Estado(novaMatriz, calculaValor(copiaTabuleiro));
                    sucessores.add(sucessor);

                    copiaTabuleiro[linha][coluna] = 0;
                }
            }

            /* volta a rainha para posicao anterior */
            copiaTabuleiro[posLinha][posColuna] = 1;
        }

        if (sucessores.size() > 0) {
            Collections.sort(sucessores);
            int menorValor = sucessores.get(0).getValor();

            ArrayList<Estado> resultados = new ArrayList<Estado>();
            for (Estado r : sucessores)
                if (r.getValor() == menorValor)
                    resultados.add(r);
            
            Collections.shuffle(resultados);
            resultado = resultados.get(0);
        }

        return resultado;
    }

    public static final int calculaValor(int[][] estado) {
        int valor = 0;
        int posLinha = 0, posColuna = 0;
        int tamanho = estado.length;

        for (int coluna = 0; coluna < estado.length; coluna++) {
            /* procurando pela rainha na coluna */
            for (int linha = 0; linha < estado.length; linha++) {
                if (estado[linha][coluna] == 1) {
                    posLinha = linha;
                    posColuna = coluna;
                    break;
                }
            }

            /* calcula quantos pares de rainhas estão em ataque */
            for (int i = 1; i < tamanho; i++) {
                // verifica a diagonal superior
                if ((((posLinha - i) >= 0) && (posColuna + i) < tamanho) && estado[posLinha - i][posColuna + i] == 1)
                    valor += 1;
                // verifica a diagonal inferior
                if ((((posLinha + i) < tamanho) && (posColuna + i) < tamanho) && estado[posLinha + i][posColuna + i] == 1)
                    valor += 1;
                // verifica o lado direito
                if (((posColuna + i) < tamanho) && estado[posLinha][posColuna + i] == 1)
                    valor += 1;
            }
        }
        return valor;
    }

    public Estado getEstadoInicial() {
        return this.estadoInicial;
    }

    public void setEstadoInicial(Estado estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public int[][] clonaMatriz(int[][] list) {
        int[][] clone = new int[list.length][list.length];

        for (int linha = 0; linha < list.length; linha++)
            for (int coluna = 0; coluna < list.length; coluna++) 
                clone[linha][coluna] = list[linha][coluna];

        return clone;
    }

    private int[][] criaTabuleiroAleatorio(int n) {
        int[][] tabuleiro = new int[n][n];

        for (int coluna = 0; coluna < n; coluna++)
            tabuleiro[(int)(0 + Math.random() * n)][coluna] = 1;

        return tabuleiro;
    }

}
