package brandubh.util;

/**
* @author David Santamaria Carrillo
*/

public class Traductor {
    private static final int TAMANO_TABLERO = 7;

    public static Coordenada consultarCoordenadaParaNotacionAlgebraica(String texto) {
        if (texto == null || texto.length() != 2) {
            return null;
        }
        
        char columna = texto.charAt(0);
        char fila = texto.charAt(1);
        
        if (columna < 'a' || columna >= 'a' + TAMANO_TABLERO ||
            fila < '1' || fila > '0' + TAMANO_TABLERO) {
            return null;
        }
        
        int filaNumerica = fila - '1';
        int columnaNumerica = columna - 'a';
        
        return new Coordenada(filaNumerica, columnaNumerica);
    }

    public static String consultarTextoEnNotacionAlgebraica(Coordenada coordenada) {
        if (coordenada == null || coordenada.getFila() < 0 || coordenada.getFila() >= TAMANO_TABLERO ||
            coordenada.getColumna() < 0 || coordenada.getColumna() >= TAMANO_TABLERO) {
            return null;
        }
        
        char fila = (char) ('1' + coordenada.getFila());
        char columna = (char) ('a' + coordenada.getColumna());
        
        return Character.toString(columna) + Character.toString(fila);
    }

    public static boolean esTextoCorrectoParaCoordenada(String texto) {
        if (texto == null || texto.length() != 2) {
            return false;
        }

        char columna = texto.charAt(0);
        char fila = texto.charAt(1);
        
        return (columna >= 'a' && columna < 'a' + TAMANO_TABLERO) &&
               (fila >= '1' && fila <= '0' + TAMANO_TABLERO);
    }
}
