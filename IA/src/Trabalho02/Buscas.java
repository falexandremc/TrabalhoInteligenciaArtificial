package Trabalho02;

public class Buscas {
	public Rainhas subidaE(Rainhas inicio) {
		int i=0;
		while(true) {
			if (inicio.getnColi()==0){
				return inicio;
			}
			Rainhas rainha=inicio.vizinhos();
			if(rainha.getnColi()< inicio.getnColi()) {
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
