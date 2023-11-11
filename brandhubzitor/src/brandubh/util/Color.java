package brandubh.util;
/**
 *  Autor: Pablo Citores
 *  Grupo 103
 *  Enumeración para representar colores.
 */

public enum Color {
    BLANCO('B'),
    NEGRO('N');

    private char letra;

    private Color(char letra) {
        this.letra = letra;
    }

    public Color consultarContrario() {
        return this.equals(BLANCO)? NEGRO: BLANCO;
    }
    
    public char toChar() {
        return letra;
    }
}

