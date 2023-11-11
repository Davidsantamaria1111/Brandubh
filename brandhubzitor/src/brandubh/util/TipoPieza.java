package brandubh.util;
/**
 *  Autor: Pablo Citores
 *  Grupo 103
 *  Enumeración para representar colores.
 */

public enum TipoPieza {
	ATACANTE ('A', Color.NEGRO),
	DEFENSOR ('D', Color.BLANCO),
	REY ('R', Color.BLANCO);
	
	private char caracter;
	private Color color;
	
	private TipoPieza(char letra, Color color) {
		this.caracter = letra;
		this.color = color;
	}
	
	public char toChar() {
		return caracter;
	}
	
	public Color consultarColor() {
		return color;
	}
}
