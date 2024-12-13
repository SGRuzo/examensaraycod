/**
 * Funciones para que el código quede más claro y sea más fácil de mantener.
 * @version 1.0
 * @author SarayGRuzo
 */
public class FuncionesDamas {

    // Tablero de damas de 8x8
    private char[][] tablero = new char[8][8];

    /**
     * Constructor que inicializa el tablero con las piezas.
     */
    public void Damas() {
        // Inicializa el tablero con piezas
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) {
                    if (i < 3) {
                        tablero[i][j] = 'B'; // Piezas negras en las tres primeras filas
                    } else if (i > 4) {
                        tablero[i][j] = 'N'; // Piezas blancas en las tres últimas filas
                    } else {
                        tablero[i][j] = ' '; // Espacios vacíos en el medio
                    }
                } else {
                    tablero[i][j] = ' '; // Espacios vacíos en el tablero
                }
            }
        }
    }


    /**
     * Convertir una pieza en reina cuando llega a la fila opuesta.
     *
     * @param x La fila de la pieza.
     * @param y La columna de la pieza.
     * @param color El color de la pieza ('B' para negra, 'N' para blanca).
     */
    public void convertirEnReina(int x, int y, char color) {
        // Si es una pieza negra que llega a la fila 7, o una pieza blanca que llega a la fila 0
        if ((color == 'B' && x == 7) || (color == 'N' && x == 0)) {
            tablero[x][y] = Character.toUpperCase(color); // Se convierte en reina
        }
    }

    /**
     * Verificar si un movimiento es correcto (en diagonal).
     *
     * @param x1 Fila de la pieza inicial.
     * @param y1 Columna de la pieza inicial.
     * @param x2 Fila de la pieza destino.
     * @param y2 Columna de la pieza destino.
     * @return true si el movimiento es diagonal, false si no lo es.
     */
    public boolean verificarMovimiento(int x1, int y1, int x2, int y2) {
        // Verifica si el movimiento es en diagonal (diferencia de fila igual a la diferencia de columna)
        if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
            return true;
        } else {
            System.out.println("Movimiento no válido, debe ser diagonal.");
            return false;
        }
    }

    /**
     * Permitir comer una pieza contraria si la jugada es válida.
     *
     * @param x1 Fila de la pieza inicial.
     * @param y1 Columna de la pieza inicial.
     * @param x2 Fila de la pieza destino.
     * @param y2 Columna de la pieza destino.
     * @return true si se ha comido una pieza contraria, false si no.
     */
    public boolean comerPieza(int x1, int y1, int x2, int y2) {
        // Verifica si el movimiento es correcto en diagonal
        if (verificarMovimiento(x1, y1, x2, y2)) {
            int midX = (x1 + x2) / 2;
            int midY = (y1 + y2) / 2;

            // Verifica que la pieza del medio sea contraria
            if (tablero[midX][midY] != ' ' && tablero[midX][midY] != tablero[x1][y1]) {
                // Se come la pieza, vacía la posición intermedia
                tablero[midX][midY] = ' ';
                return true;
            } else {
                System.out.println("No se puede comer, no hay una pieza contraria.");
                return false;
            }
        }
        return false;
    }

    /**
     * Muestra el tablero de damas.
     */
    public void mostrarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }


}
