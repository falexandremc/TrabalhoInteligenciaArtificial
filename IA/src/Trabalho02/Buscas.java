package Trabalho02;

public class Buscas {
	public Rainhas subidaE(Rainhas inicio) {
		int i=0;
		while(true) {
			if (inicio.getNumColisao()==0){
				return inicio;
			}
			Rainhas rainha=inicio.vizinhos();
			if(rainha.getNumColisao()< inicio.getNumColisao()) {
					inicio=rainha;
					i++;
			}else {
				if(i==3) {
					
				}else {
					return null;
				}
				
			}
		}
		
		
		
	}
}
