

package brandubh.modelo;

/**
 *  Autor: Pablo Citores
 *  Grupo 103
 */
import brandubh.util.Sentido;

public class Jugada {

    private Celda origen;
    private Celda destino;

    public Jugada(Celda origen, Celda destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Sentido consultarSentido() {
        int diffX = destino.getCoordenada().fila() - origen.getCoordenada().fila();
        int diffY = destino.getCoordenada().columna() - origen.getCoordenada().columna();

        if (diffX == 0 && diffY != 0) {
            return (diffY > 0) ? Sentido.VERTICAL_S : Sentido.VERTICAL_N;
        } else if (diffY == 0 && diffX != 0) {
            return (diffX > 0) ? Sentido.HORIZONTAL_E : Sentido.HORIZONTAL_O;
        }

        return null;
    }

    public boolean esMovimientoHorizontalOVertical() {
        Sentido sentido = consultarSentido();
        return sentido != null;
    }

    // Agrega los getters y setters según sea necesario
}

