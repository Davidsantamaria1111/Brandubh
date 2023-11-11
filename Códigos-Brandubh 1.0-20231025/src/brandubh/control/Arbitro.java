package brandubh.control;

import brandubh.modelo.Tablero;
import brandubh.util.Color;
import brandubh.util.TipoPieza;
import brandubh.util.Coordenada;

/**
*@author David Santamaria Carrillo
*/

public class Arbitro {
	    private Tablero tablero;
	    private int numeroJugada;
	    private Color turno;

	    public Arbitro() {
	        tablero = new Tablero(7, 7);
	        numeroJugada = 0;
	        turno = Color.NEGRO; // Empieza el atacante con piezas negras
	    }

	    public void cambiarTurno() {
	        turno = (turno == Color.BLANCO) ? Color.NEGRO : Color.BLANCO;
	    }

	    public void colocarPiezas(TipoPieza[] piezas, Coordenada[] coordenadas, Color color) {
	        for (int i = 0; i < piezas.length; i++) {
	            Pieza pieza = new Pieza(piezas[i]);
	            tablero.colocar(coordenadas[i], pieza);
	        }
	        turno = color;
	    }

	    public void colocarPiezasConfiguracionInicial() {
	        // Implementar colocación de piezas según la configuración inicial del juego
	        // y el inicio del juego con el turno para el atacante con piezas negras
	    }

	    public int consultarNumeroJugada() {
	        return numeroJugada;
	    }

	    public Tablero consultarTablero() {
	        return tablero.clonar();
	    }

	    public Color consultarTurno() {
	        return turno;
	    }

	    public boolean esMovimientoLegal(Jugada jugada) {
	        // Implementar la lógica para verificar si la jugada es legal según las reglas del juego
	        return false; // Reemplazar con la implementación real
	    }

	    public boolean haGanadoAtacante() {
	        // Implementar la lógica para verificar si el rey ha sido capturado por el atacante
	        return false; // Reemplazar con la implementación real
	    }

	    public boolean haGanadoRey() {
	        // Implementar la lógica para verificar si el rey ha alcanzado una de las provincias
	        return false; // Reemplazar con la implementación real
	    }

	    public void mover(Jugada jugada) {
	        // Implementar la lógica para realizar el movimiento
	        // Mover la pieza de origen a destino
	        // Almacenar la información del último movimiento
	    }

	    public void realizarCapturasTrasMover() {
	        // Implementar la lógica para retirar del tablero las piezas capturadas tras el último movimiento
	    }
	}
