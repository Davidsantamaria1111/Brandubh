package brandubh.modelo;
/**
 *  Autor: Pablo Citores y David Santamaría
 *  Grupo 103
 */

import brandubh.util.Color;
import brandubh.util.TipoPieza;

public class Pieza {

    private final TipoPieza tipoPieza;
    private final Color color;

    public Pieza(TipoPieza tipoPieza) {
        this.tipoPieza = tipoPieza;

        // Asignar color según el tipo de pieza
        if (tipoPieza == TipoPieza.ATACANTE) {
            this.color = Color.NEGRO;
        } else {
            this.color = Color.BLANCO;
        }
    }

    public Pieza clonar() {
        // Implementa la lógica de clonación según tus necesidades
        return new Pieza(this.tipoPieza);
    }

    public Color consultarColor() {
        return this.color;
    }

    public TipoPieza consultarTipoPieza() {
        return this.tipoPieza;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pieza pieza = (Pieza) obj;

        if (tipoPieza != pieza.tipoPieza) return false;
        return color == pieza.color;
    }

    @Override
    public int hashCode() {
        int result = tipoPieza.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pieza{" +
                "tipoPieza=" + tipoPieza +
                ", color=" + color +
                '}';
    }
}

