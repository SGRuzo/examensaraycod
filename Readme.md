# Examen 1ª Evaluación
Apartados:

Realiza el diagrama de flujo para recorrer un tablero (8x8) de "Damas", sacando por pantalla si la casilla está ocupada (mostrando la coordenada) y que tipo de ficha es. Además cuenta las fichas de cada jugador sacando por pantalla quien va ganando. No hace falta usar funciones. Adjunta imagen y que se vea en el Readme
¿Como es el tablero? Pon un ejemplo
Enumera funciones (mínimo tres) que se podrían utilizar para que el código quede más claro y sea más fácil de mantener.
Realiza el javadoc de estas funciones
---

Explica a continación cada apartado del examen
Con cada apartado realiza un commit diferente

![image](diagramaflujoDamas.png)
##Pasos: 

1. tabla 8x8, 12B, 12N 
2. mostrar tablero con las piezas en posicion inicial.
3. usuario decide movimiento
    a)si no mueve en diagonal, "prueba otro movimiento"
    b)si mueve 1posicion en diagonal= se registra el movimiento y se muestra tablero
4. si una pieza alcanza fila opuesta
    a)se convierte en reina, actualiza tablero y la reina se llama "RB" o "RN"
5. gana B si N=0
6. gana N si B=0
7. si pieza mueve en diagonal donde hay pieza contraria, se la come

##¿Como es el tablero?
````
public class TableroDamas {
    public static void main(String[] args) {
        String[][] tablero = new String[8][8]; //Creacion del tablero       
        // Colocamos piezas negras en las primeras tres filas
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 8; col++) {
                if ((fila + col) % 2 != 0) { // Solo en casillas oscuras
                    tablero[fila][col] = "N"; // Ficha negra
                }
            }
        }

        // Colocamos piezas B en las últimas tres filas
        for (int fila = 5; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                if ((fila + col) % 2 != 0) { // Solo en casillas oscuras
                    tablero[fila][col] = "B"; // Ficha blanca
                }
            }
        }
````

##3Funciones 
````
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
````

````
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

````

````
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
````

