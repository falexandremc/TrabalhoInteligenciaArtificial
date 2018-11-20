package Trabalho02;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rainhas r=new Rainhas(15);
		r=Rainhas.rainhaAleatoria(15);
		Buscas b= new Buscas();
		r=b.subidaE(r);
		r.imprime();
		System.out.println(" C "+r.getNumColisao());
		 
	}

}
