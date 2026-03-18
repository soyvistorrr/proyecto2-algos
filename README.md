# Proyecto 2: Mundo Chiquito

**Curso:** CI-2693 - Laboratorio de Algoritmos y Estructuras III

## Integrantes

* Victor Hernandez, Carnet: 20-10349
* Daniela Gragirena, Carnet: 19-10543

## Descripción del Proyecto

Este proyecto consiste en el desarrollo de un algoritmo en Kotlin diseñado para encontrar todas las combinaciones posibles de cartas mostro (puentes) que satisfagan las estrictas condiciones de la carta "Mundo Chiquito".
Para que una terna de cartas sea válida, la primera carta (en mano) debe compartir **exactamente una** característica (nivel, poder o atributo) con la segunda carta (en el mazo), y esta a su vez debe compartir **exactamente una** característica con una tercera carta (buscada en el mazo).

## Arquitectura y Estructuras de Datos

La solución modela el problema utilizando Teoría de Grafos:

* **Vértices:** Cada línea válida del archivo `deck.csv` se procesa y se instancia como un objeto de la clase `CartaMostro`.
* **Aristas:** Se construyó un grafo no dirigido utilizando una **Lista de Adyacencia**. Existe una arista entre el vértice $u$ y el vértice $v$ si, y solo si, ambas cartas comparten exactamente una característica.
* **Búsqueda:** El algoritmo recorre la lista de adyacencia buscando caminos simples de longitud 2 (ternas de la forma $A \rightarrow B \rightarrow C$). Se implementó un filtro de índices ($i < k$) para evitar ciclos redundantes y permutaciones duplicadas en la salida final.

## Complejidad

* **Construcción del Grafo:** $O(V^2)$, donde $V$ es el número total de vértices (cartas). Se compara cada carta con el resto para determinar las conexiones.
* **Búsqueda de Ternas:** En el peor de los casos (un grafo completo), el recorrido toma $O(V^3)$. Sin embargo, al tratarse de un grafo disperso condicionado a similitudes exactas, el tiempo real de ejecución es significativamente menor.

## Requisitos y Compilación

* **Lenguaje:** Kotlin (JDK 11 o superior).
* **Archivos requeridos:** El ejecutable requiere de un archivo llamado `deck.csv` en el directorio raíz, con la estructura: `Nombre, Nivel, Atributo, Poder`.

**Para compilar y ejecutar mediante consola:**

```bash
kotlinc MundoChiquito.kt CartaMostro.kt -include-runtime -d MundoChiquito.jar
java -jar MundoChiquito.jar
```
