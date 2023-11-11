package brandubh.util;


/**
*@author David Santamaria Carrillo
*/

public enum Color {
    BLANCO('B'),
    NEGRO('N');

    private char codigo;

    private Color(char codigo) {
        this.codigo = codigo;
    }

    public char getCodigo() {
        return codigo;
    }

    public Color consultarContrario() {
        if (this == BLANCO) {
            return NEGRO;
        } else {
            return BLANCO;
        }
    }
}