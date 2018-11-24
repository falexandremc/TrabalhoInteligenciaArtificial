package Trabalho02;

public class Buscas {
	public Rainhas subidaE(Rainhas inicio) {
		while(true) {
			inicio.calculaNumColisao();
			if (inicio.getNumColisao()==0){
				return inicio;
			}
			Rainhas rainha=inicio.vizinho();
			rainha.calculaNumColisao();
			if(rainha.getNumColisao()< inicio.getNumColisao()) {
				inicio=rainha;
			}else {
				inicio=Rainhas.rainhaAleatoria(inicio.getTamTabuleiro());
				continue;

			}
		}

	}
}
