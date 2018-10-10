import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class Regua {
    private Character regua[];
    //o atributo n constitui o tamanho da regua atraves da formula (2*n)+1
    private int n;
    //Esse predecessor ser� utilizado para descobrirmos a partir de um estado qual o estado anterior e com isso o caminho
    private Regua predecessor;
    //Gente, estou achando que esta lista de sucessores ser� suficiente para sabermos o caminho do estado inicial at� o final
    private ArrayList<Regua> sucessores;

    public Regua(int n,String regua) {
        //setando n que constitui o tamanho da regua atraves da formula (2*n)+1
        this.n = n;        
        //iniciando a regua com um vetor de (2*n)+1 posições
        this.regua = new Character[(2*n)+1];
        //repassando os valores de entrada para a regua
        for (int i = 0; i < regua.length(); i++)
            this.regua[i]=regua.charAt(i);
        
    }
    /**
     *@return tamanho da regua
     */
    public int getSize() {
        return (2*n)+1;
    }
    /**
     *@return n que constitui o tamanho da regua atraves da formula (2*n)+1
     */
    public int getN() {
        return n;
    }
    public Character[] getRegua() {
    	return regua;
    }
    /**
     * Insere um bloco A ou B ou # na regua
     * @param i indice da regua na qual será inserido o bloco
     * @param c bloco A ou B ou # a ser inserido na regua
     */
    public void setI(int i, char c){
        regua[i]=c;
    }
    /**
     * Troca dois blocos distintos A ou B ou # na regua se estes não estao a mais de n blocos de distancia
     * @param i indice da regua na qual será inserido o bloco j
     * @param j indice da regua na qual será inserido o bloco i
     */
    public void troca(int i,int j){
        String erro = "A troca dos blocos nos indices "+i+" e "+j+" Viola as regras de troca";
        //verificando se as regras de troca estão sendo obedecidas.
        if(!(Math.abs(i-j)<=n&&i!=j))
            throw new IllegalArgumentException(erro);
        try {
            Character aux = regua[i];
            regua[i]=regua[j];
            regua[j]=aux;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(erro+" pois os indices estao fora da regua");
        }
    }
    
    
}
