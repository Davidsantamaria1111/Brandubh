package brandubh.util;

/**
* @author David Santamaria Carrillo
*/

public enum TipoPieza {
    DEFENSOR('D', Color.BLANCO),  // Pieza defensora de color blanco
    ATACANTE('A', Color.NEGRO),   // Pieza atacante de color negro
    REY('R', Color.BLANCO);       // Pieza rey de color blanco

    private char caracter;
    private Color color;

    private TipoPieza(char caracter, Color color) {
        this.caracter = caracter;
        this.color = color;
    }

    public char getCaracter() {
        return caracter;
    }

    public Color getColor() {
        return color;
    }
}



