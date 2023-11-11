/**
 *  Autor: Pablo Citores
 *  Grupo 103
 *  Enumeración para representar colores.
 */

package brandubh.modelo;

/**
 *  Autor: Pablo Citores
 *  Grupo 103
 */

import brandubh.util.Coordenada;
import brandubh.util.Color;
import brandubh.util.TipoCelda;



public class Celda {

    private Coordenada coordenada;
    private TipoCelda tipoCelda;
    private Pieza pieza;


    public Celda(Coordenada coordenada, TipoCelda tipoCelda) {
        this.coordenada = coordenada;
        this.tipoCelda = tipoCelda;
    }

    public Celda(Coordenada coordenada) {
        this(coordenada, TipoCelda.NORMAL);
    }

    public Celda clonar() {
        Celda clon = new Celda(this.coordenada.clonar(), this.tipoCelda);
        if (this.pieza != null) {
            clon.colocar(this.pieza.clonar());
        }
        return clon;
    }


    public void colocar(Pieza pieza) {
        this.pieza = pieza;
    }


    public Color consultarColorDePieza() {
        if (this.pieza != null) {
            return this.pieza.consultarColor();
        }
        return null;
    }
    
    public Coordenada getCoordenada() {
        return coordenada;
    }

    public Coordenada consultarCoordenada() {
        return this.coordenada;
    }

    public Pieza consultarPieza() {
        return this.pieza;
    }

    public TipoCelda consultarTipoCelda() {
        return this.tipoCelda;
    }

    public void eliminarPieza() {
        this.pieza = null;
    }

    public boolean estaVacia() {
        return this.pieza == null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Celda celda = (Celda) obj;
        return coordenada.equals(celda.coordenada) && tipoCelda == celda.tipoCelda
                && (pieza != null ? pieza.equals(celda.pieza) : celda.pieza == null);
    }

    @Override
    public int hashCode() {
        int result = coordenada.hashCode();
        result = 31 * result + tipoCelda.hashCode();
        result = 31 * result + (pieza != null ? pieza.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Celda{" + "coordenada=" + coordenada + ", tipoCelda=" + tipoCelda + ", pieza=" + pieza + '}';
    }
}
