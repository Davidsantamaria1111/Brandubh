package brandubh.modelo;

import brandubh.util.Color;
import brandubh.util.TipoPieza;

/**
* @author David Santamaria Carrillo
*/

public class Pieza {
    private TipoPieza tipoPieza;

    public Pieza(TipoPieza tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    public Pieza clonar() {
        return new Pieza(tipoPieza);
    }

    public Color consultarColor() {
        return tipoPieza.getColor();
    }

    public TipoPieza getTipoPieza() {
        return tipoPieza;
    }
}
