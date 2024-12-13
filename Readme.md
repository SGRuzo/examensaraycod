# Examen 1ª Evaluación
Apartados:

Realiza el diagrama de flujo para recorrer un tablero (8x8) de "Damas", sacando por pantalla si la casilla está ocupada (mostrando la coordenada) y que tipo de ficha es. Además cuenta las fichas de cada jugador sacando por pantalla quien va ganando. No hace falta usar funciones. Adjunta imagen y que se vea en el Readme
¿Como es el tablero? Pon un ejemplo
Enumera funciones (mínimo tres) que se podrían utilizar para que el código quede más claro y sea más fácil de mantener.
Realiza el javadoc de estas funciones
---

Explica a continación cada apartado del examen

![image](/home/dam/Imágenes/COD/diagramaflujoDamas.png)
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


Con cada apartado realiza un commit diferente