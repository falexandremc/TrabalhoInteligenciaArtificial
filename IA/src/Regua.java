
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alexandre
 */
public class Regua implements Comparable<Regua> {

    private Character regua[];
    //o atributo n constitui o tamanho da regua atraves da formula (2*n)+1
    private int n;
    //Esse predecessor ser� utilizado para descobrirmos a partir de um estado qual o estado anterior e com isso o caminho
    private Regua predecessor;
    //indice do #
    private int indice;
    private int profundidade;
    private int g;
    private int h;
    private boolean expandido = false;

    public Regua(int n, Character regua[]) {
        this.n = n;
        this.regua = regua;
        for (int i = 0; i < regua.length; i++) {
            if (this.regua[i] == '#') {
                this.indice = i;
            }
        }
    }

    public Regua(int n, String regua) {
        //setando n que constitui o tamanho da regua atraves da formula (2*n)+1
        this.n = n;
        //iniciando a regua com um vetor de (2*n)+1 posições
        this.regua = new Character[(2 * n) + 1];
        //repassando os valores de entrada para a regua
        for (int i = 0; i < regua.length(); i++) {
            this.regua[i] = regua.charAt(i);
            //System.out.print(this.regua[i]);
            if (this.regua[i] == '#') {
                this.indice = i;
            }
        }

    }

    /**
     * @return tamanho da regua
     */
    public int getSize() {
        return (2 * n) + 1;
    }

    /**
     * @return n que constitui o tamanho da regua atraves da formula (2*n)+1
     */
    public int getN() {
        return n;
    }

    public Character[] getRegua() {
        return regua;
    }

    /**
     * Insere um bloco A ou B ou # na regua
     *
     * @param i indice da regua na qual será inserido o bloco
     * @param c bloco A ou B ou # a ser inserido na regua
     */
    public void setI(int i, char c) {
        regua[i] = c;
    }

    /**
     * Troca dois blocos distintos A ou B ou # na regua se estes não estao a
     * mais de n blocos de distancia
     *
     * @param i indice da regua na qual será inserido o bloco j
     * @param j indice da regua na qual será inserido o bloco i
     * @return true se a troca foi bem sucedida e false caso contrario.
     */
    public boolean troca(int i, int j) {
        //verificando se as regras de troca estão sendo obedecidas.
        if (!(Math.abs(i - j) <= n && i != j)) {
            return false;
        }
        try {
            if (regua[i] == '#') {
                indice = j;
            } else {
                indice = i;
            }
            Character aux = regua[i];
            regua[i] = regua[j];
            regua[j] = aux;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Regua) {
            return toString().equals(((Regua) obj).toString());
        }
        return false;
    }

    // gera sucessores 
    public ArrayList<Regua> sucessores() {
        ArrayList<Regua> su = new ArrayList<Regua>();
        for (int i = indice - 1; i >= 0; i--) {
            Regua r = new Regua(n, Arrays.copyOf(regua, regua.length));
            //r.setPredecessor(this);
            if (r.troca(i, indice)) {
                r.g = this.g + Math.abs(i - indice);
                su.add(r);
            }
        }
        for (int i = indice + 1; i < getSize(); i++) {
            Regua r = new Regua(n, Arrays.copyOf(regua, regua.length));
            //r.setPredecessor(this);
            if (r.troca(i, indice)) {
                r.g = this.g + Math.abs(i - indice);
                su.add(r);
            }
        }
        this.setExpandido(true);
        return su;
    }

    public Regua getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Regua predecessor) {
        this.predecessor = predecessor;
    }

    public String toString() {
        return Arrays.toString(regua);
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public int compareTo(Regua o) {
        if (this.g + this.h > o.g + o.h) {
            return 1;
        } else if (this.g + this.h < o.g + o.h) {
            return -1;
        } else {
            return 0;
        }
    }

    public void calc_H() {
        h = 0;
        for (int i = 0; i < this.n; i++) {
            if (this.regua[i] != 'A') {
                h++;
            }
        }

    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    /**
     * @return the expandido
     */
    public boolean isExpandido() {
        return expandido;
    }

    /**
     * @param expandido the expandido to set
     */
    public void setExpandido(boolean expandido) {
        this.expandido = expandido;
    }

}
