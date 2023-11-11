package brandubh.modelo;

import brandubh.util.Coordenada;
import brandubh.util.Sentido;

/**
* @author David Santamaria Carrillo
*/


public class Jugada {
    private Coordenada origen;
    private Coordenada destino;

    public Jugada(Coordenada origen, Coordenada destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Sentido consultarSentido() {
        int filaOrigen = origen.getFila();
        int columnaOrigen = origen.getColumna();
        int filaDestino = destino.getFila();
        int columnaDestino = destino.getColumna();

        int diferenciaFilas = filaDestino - filaOrigen;
        int diferenciaColumnas = columnaDestino - columnaOrigen;

        // Comprobamos si la jugada es en uno de los cuatro sentidos permitidos
        if (diferenciaFilas == 0 && Math.abs(diferenciaColumnas) == 1) {
            return diferenciaColumnas > 0 ? Sentido.HORIZONTAL_E : Sentido.HORIZONTAL_O;
        } else if (diferenciaColumnas == 0 && Math.abs(diferenciaFilas) == 1) {
            return diferenciaFilas > 0 ? Sentido.VERTICAL_S : Sentido.VERTICAL_N;
        } else {
            return null; // No es un movimiento en uno de los cuatro sentidos legales
        }
    }

    public boolean esMovimientoHorizontalOVertical() {
        Sentido sentido = consultarSentido();
        return sentido == Sentido.HORIZONTAL_E || sentido == Sentido.HORIZONTAL_O ||
               sentido == Sentido.VERTICAL_N || sentido == Sentido.VERTICAL_S;
    }

    public Coordenada getOrigen() {
        return origen;
    }

    public Coordenada getDestino() {
        return destino;
    }
}
