package brandubh.modelo;


/**
 *  Autor: Pablo Citores y David Santamaría
 *  Grupo 103
 */

import brandubh.util.Coordenada;
import brandubh.util.TipoPieza;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Tablero {
	private static final int FILAS = 7;
    private static final int COLUMNAS = 7;

    private Celda[][] celdas;

    // Constructor
    public Tablero() {
        celdas = new Celda[FILAS][COLUMNAS];
        inicializarTablero();
    }

    // Inicializar el tablero con celdas vacías
    private void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                celdas[i][j] = new Celda(new Coordenada(i, j));
            }
        }
    }

    public String aTexto() {
        StringBuilder resultado = new StringBuilder();
        for (int i = FILAS - 1; i >= 0; i--) {
            resultado.append(i + 1).append(" ");
            for (int j = 0; j < COLUMNAS; j++) {
                resultado.append(celdas[i][j].toString()).append(" ");
            }
            resultado.append("\n");
        }
        resultado.append("  a b c d e f g");
        return resultado.toString();
    }

    public Tablero clonar() {
        Tablero tableroClonado = new Tablero();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tableroClonado.celdas[i][j] = this.celdas[i][j].clonar();
            }
        }
        return tableroClonado;
    }

    public void colocar(Pieza pieza, Coordenada coordenada) {
        if (coordenadaEnTablero(coordenada) && pieza != null) {
            celdas[coordenada.getFila()][coordenada.getColumna()].colocar(pieza);
        }
    }

    public Celda consultarCelda(Coordenada coordenada) {
        if (coordenadaEnTablero(coordenada)) {
            return celdas[coordenada.getFila()][coordenada.getColumna()].clonar();
        }
        return null;
    }

    public Celda[] consultarCeldas() {
        Celda[] celdasClonadas = new Celda[FILAS * COLUMNAS];
        int index = 0;

        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                celdasClonadas[index++] = celdas[fila][columna].clonar();
            }
        }

        return celdasClonadas;
    }

    public Celda[] consultarCeldasContiguas(Coordenada coordenada) {
        if (coordenadaEnTablero(coordenada)) {
            List<Celda> celdasContiguas = new ArrayList<>();

            // Coordenadas de las celdas contiguas
            Coordenada[] coordenadasContiguas = {
                    new Coordenada(coordenada.getFila() - 1, coordenada.getColumna()), // Arriba
                    new Coordenada(coordenada.getFila() + 1, coordenada.getColumna()), // Abajo
                    new Coordenada(coordenada.getFila(), coordenada.getColumna() - 1), // Izquierda
                    new Coordenada(coordenada.getFila(), coordenada.getColumna() + 1)  // Derecha
            };

            for (Coordenada contigua : coordenadasContiguas) {
                if (coordenadaEnTablero(contigua)) {
                    celdasContiguas.add(celdas[contigua.getFila()][contigua.getColumna()].clonar());
                }
            }

            return celdasContiguas.toArray(new Celda[0]);
        }

        return null;
    }


    public Celda[] consultarCeldasContiguasEnHorizontal(Coordenada coordenada) {
        if (!coordenadaEnTablero(coordenada)) {
            return new Celda[0];
        }

        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        // Coordenadas de las celdas contiguas en horizontal
        Coordenada[] contiguasCoordenadas = {
                new Coordenada(fila, columna - 1),
                new Coordenada(fila, columna + 1)
        };

        return Arrays.stream(contiguasCoordenadas)
                .filter(this::coordenadaEnTablero)
                .map(this::consultarCelda)
                .toArray(Celda[]::new);
    }

    public Celda[] consultarCeldasContiguasEnVertical(Coordenada coordenada) {
        if (!coordenadaEnTablero(coordenada)) {
            return new Celda[0];
        }

        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        // Coordenadas de las celdas contiguas en vertical
        Coordenada[] contiguasCoordenadas = {
                new Coordenada(fila - 1, columna),
                new Coordenada(fila + 1, columna)
        };

        return Arrays.stream(contiguasCoordenadas)
                .filter(this::coordenadaEnTablero)
                .map(this::consultarCelda)
                .toArray(Celda[]::new);
    }

    public int consultarNumeroPiezas(TipoPieza tipoPieza) {
        int contador = 0;

        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                Celda celda = celdas[fila][columna];
                if (celda.consultarPieza() != null && celda.consultarPieza().consultarTipoPieza() == tipoPieza) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public void eliminarPieza(Coordenada coordenada) {
        if (coordenadaEnTablero(coordenada)) {
            celdas[coordenada.getFila()][coordenada.getColumna()].eliminarPieza();
        }
    }

    public Celda obtenerCelda(Coordenada coordenada) {
        if (coordenadaEnTablero(coordenada)) {
            return celdas[coordenada.getFila()][coordenada.getColumna()];
        }
        return null;
    }

    private boolean coordenadaEnTablero(Coordenada coordenada) {
        return coordenada != null && coordenada.getFila() >= 0 && coordenada.getFila() < FILAS
                && coordenada.getColumna() >= 0 && coordenada.getColumna() < COLUMNAS;
    }
}



