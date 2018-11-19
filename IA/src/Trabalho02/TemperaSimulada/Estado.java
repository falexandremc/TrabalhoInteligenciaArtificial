package Trabalho02.TemperaSimulada;

public class Estado implements Comparable<Estado> {

    private int[][] tabuleiro;
    private int valor;

    Estado(int[][] tabuleiro, int valor) {
        this.tabuleiro = tabuleiro;
        this.valor = valor;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] estado) {
        this.tabuleiro = estado;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Estado o) {
        if (this.valor == o.getValor())
            return 0;
        else if (this.valor < o.getValor())
            return -1;
        else
            return 1;
    }
}
