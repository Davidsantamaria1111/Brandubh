package brandubh.modelo;

import brandubh.util.Coordenada;
import brandubh.util.TipoCelda;
import brandubh.util.Color;

/**
*@author David Santamaria Carrillo
*/

public class Celda {
    private Coordenada coordenada;
    private TipoCelda tipoCelda;
    private Pieza pieza;

    public Celda(Coordenada coordenada) {
        this.coordenada = coordenada;
        this.tipoCelda = TipoCelda.NORMAL;
        this.pieza = null;
    }

    public Celda(Coordenada coordenada, TipoCelda tipoCelda) {
        this.coordenada = coordenada;
        this.tipoCelda = tipoCelda;
        this.pieza = null;
    }

    public Celda clonar() {
        Celda celdaClon = new Celda(coordenada, tipoCelda);
        if (pieza != null) {
            celdaClon.pieza = pieza.clonar();
        }
        return celdaClon;
    }

    public void colocar(Pieza pieza) {
        this.pieza = pieza;
    }

    public Color consultarColorDePieza() {
        if (pieza != null) {
            return pieza.consultarColor();
        }
        return null;
    }

    public void eliminarPieza() {
        pieza = null;
    }

    public boolean estaVacia() {
        return pieza == null;
    }

    // Getters para consultar la coordenada y tipo de celda
    public Coordenada getCoordenada() {
        return coordenada;
    }

    public TipoCelda getTipoCelda() {
        return tipoCelda;
    }
}
