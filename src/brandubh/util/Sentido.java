package brandubh.util;

/**
* @author David Santamaria Carrillo
*/

public enum Sentido {
    VERTICAL_N(-1, 0),   // Desplazamiento hacia arriba
    VERTICAL_S(1, 0),    // Desplazamiento hacia abajo
    HORIZONTAL_E(0, 1),  // Desplazamiento hacia la derecha
    HORIZONTAL_O(0, -1); // Desplazamiento hacia la izquierda

    private int desplazamientoFilas;
    private int desplazamientoColumnas;

    private Sentido(int desplazamientoFilas, int desplazamientoColumnas) {
        this.desplazamientoFilas = desplazamientoFilas;
        this.desplazamientoColumnas = desplazamientoColumnas;
    }

    public int getDesplazamientoFilas() {
        return desplazamientoFilas;
    }

    public int getDesplazamientoColumnas() {
        return desplazamientoColumnas;
    }
}