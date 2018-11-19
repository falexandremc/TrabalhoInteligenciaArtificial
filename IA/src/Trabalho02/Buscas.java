package Trabalho02;

public class Buscas {
	public Rainhas subidaE(Rainhas inicio) {
		int i=0;
		while(true) {
			if (inicio.getNumColisao()==0){
				return inicio;
			}
			Rainhas rainha=inicio.vizinho();
			if(rainha.getNumColisao()< inicio.getNumColisao()) {
					inicio=rainha;
			}else {
				if(i<=3) {
					inicio=Rainhas.rainhaAleatoria(inicio.getTamTabuleiro());
					continue;
				}else {
					return null;
				}
			}
		}
		
		
		
	}
}
