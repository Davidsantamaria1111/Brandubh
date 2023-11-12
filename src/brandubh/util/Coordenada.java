package brandubh.util;
/**
 *  Autor: Pablo Citores y David Santamaría
 *  Grupo 103
 *  Coordenadas de una celda con su valor de fila y de columna.
 */

public record Coordenada(int fila, int columna) { 
	
	public Coordenada clonar() {
        return new Coordenada(this.fila, this.columna);
    }
	
	public int getFila() {
		return fila;
	}
	
	public int getColumna() {
		return columna;
	}
}

