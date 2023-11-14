package brandubh.modelo;

import java.util.List;
import java.util.ArrayList;
import brandubh.util.Coordenada;
import brandubh.util.TipoPieza;

/**
*@author David Santamaria Carrillo
*/

public class Tablero {
    private Celda[][] celdas; // Array de celdas de dos dimensiones
    private int filas;
    private int columnas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        celdas = new Celda[filas][columnas];

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                // Crea una celda vacía con sus coordenadas correspondientes
                Coordenada coordenada = new Coordenada(fila, columna);
                celdas[fila][columna] = new Celda(coordenada);
            }
        }
    }

    public String aTexto() {
        StringBuilder textoTablero = new StringBuilder();

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Celda celdaActual = celdas[fila][columna];
                if (!celdaActual.estaVacia()) {
                    // Si la celda no está vacía, se asume que tiene una pieza
                    // Aquí se puede agregar la lógica para representar cada tipo de pieza con un carácter
                    textoTablero.append("[X]"); // Reemplazar por la representación de la pieza
                } else {
                    textoTablero.append("[ ]"); // Si la celda está vacía
                }
            }
            textoTablero.append("\n"); // Nueva línea para la siguiente fila del tablero
        }

        return textoTablero.toString();
    }

    public Tablero clonar() {
        Tablero tableroClon = new Tablero(filas, columnas);
        
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                tableroClon.celdas[fila][columna] = celdas[fila][columna].clonar();
            }
        }
        
        return tableroClon;
    }

    public void colocar(Coordenada coordenada, Pieza pieza) {
        if (coordenada != null && coordenada.getFila() >= 0 && coordenada.getFila() < filas
                && coordenada.getColumna() >= 0 && coordenada.getColumna() < columnas
                && pieza != null) {
            celdas[coordenada.getFila()][coordenada.getColumna()].colocar(pieza);
        }
    }

    public Celda consultarCelda(Coordenada coordenada) {
        if (coordenada != null && coordenada.getFila() >= 0 && coordenada.getFila() < filas
                && coordenada.getColumna() >= 0 && coordenada.getColumna() < columnas) {
            return celdas[coordenada.getFila()][coordenada.getColumna()].clonar();
        }
        return null;
    }

    public Celda[] consultarCeldas() {
        Celda[] celdasClonadas = new Celda[filas * columnas];
        int index = 0;

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                celdasClonadas[index] = celdas[fila][columna].clonar();
                index++;
            }
        }

        return celdasClonadas;
    }


    public Celda[] consultarCeldasContiguas(Coordenada coordenada) {
        List<Celda> celdasContiguas = new ArrayList<>();

        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        // Definir los límites de búsqueda para las celdas contiguas
        int filaInicio = Math.max(0, fila - 1);
        int filaFin = Math.min(filas - 1, fila + 1);
        int columnaInicio = Math.max(0, columna - 1);
        int columnaFin = Math.min(columnas - 1, columna + 1);

        // Recorrer las celdas en el rango especificado y agregar las celdas contiguas
        for (int i = filaInicio; i <= filaFin; i++) {
            for (int j = columnaInicio; j <= columnaFin; j++) {
                if (i != fila || j != columna) {
                    celdasContiguas.add(celdas[i][j].clonar()); // Agregar un clon en profundidad de la celda
        }
    }

        return celdasContiguas.toArray(new Celda[0]);
        }
		return null;
    }


    public Celda[] consultarCeldasContiguasEnHorizontal(Coordenada coordenada) {
        List<Celda> celdasContiguasHorizontal = new ArrayList<>();

        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        // Definir los límites de búsqueda para las celdas contiguas en horizontal
        int columnaInicio = Math.max(0, columna - 1);
        int columnaFin = Math.min(columnas - 1, columna + 1);

        // Recorrer las celdas en el rango horizontal especificado y agregar las celdas contiguas
        for (int j = columnaInicio; j <= columnaFin; j++) {
            if (j != columna) {
                celdasContiguasHorizontal.add(celdas[fila][j].clonar()); // Agregar un clon en profundidad de la celda
            }
        }

        return celdasContiguasHorizontal.toArray(new Celda[0]);
    }



    public Celda[] consultarCeldasContiguasEnVertical(Coordenada coordenada) {
        List<Celda> celdasContiguasVertical = new ArrayList<>();

        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        // Definir los límites de búsqueda para las celdas contiguas en vertical
        int filaInicio = Math.max(0, fila - 1);
        int filaFin = Math.min(filas - 1, fila + 1);
        int columnaInicio = columna;
        int columnaFin = columna;

        // Recorrer las celdas en el rango vertical especificado y agregar las celdas contiguas
        for (int i = filaInicio; i <= filaFin; i++) {
            celdasContiguasVertical.add(celdas[i][columna].clonar()); // Agregar un clon en profundidad de la celda
        }

        return celdasContiguasVertical.toArray(new Celda[0]);
    }


    public int consultarNumeroPiezas(TipoPieza tipoPieza) {
        int contador = 0;

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Celda celdaActual = celdas[fila][columna];
                Pieza piezaActual = celdaActual.obtenerPieza();
                
                if (piezaActual != null && piezaActual.consultarTipoPieza() == tipoPieza) {
                    contador++;
                }
            }
        }

        return contador;
    }






}

