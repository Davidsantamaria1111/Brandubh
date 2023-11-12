package brandubh.util;
/**
 *  Autor: Pablo Citores y David Santamaría
 *  Grupo 103
 *  .
 */

public enum Sentido {
	
	HORIZONTAL_E(+0,+1),
	HORIZONTAL_O(+0,-1),
	VERTICAL_N(-1,+0),
	VERTICAL_S(+1,+0);
	
	private int desplazamientoEnFilas;
	private int desplazamientoEnColumnas;
	
	private Sentido (int despF, int despC) {
		this.desplazamientoEnFilas=despF;
		this.desplazamientoEnColumnas=despC;
	}
	
	public int consultarDesplazamientoEnFilas() {
		return this.desplazamientoEnFilas;
	}
	
	public int consultarDesplazamientoEnColumnas() {
		return this.desplazamientoEnColumnas;
	}
	
}
