import java.io.File

fun main() {
    val cartas = mutableListOf<CartaMostro>()
    val lineas = File("deck.csv").readLines()

    for (i in 1 until lineas.size) {

        val linea = lineas[i].trim()
        if (linea.isEmpty()) continue
        val datos = linea.split(",").map { it.trim() }
        
        if (datos.size == 4) {

            val nombre = datos[0]
            val nivel = datos[1].toInt()
            val atributo = datos[2]
            val poder = datos[3].toInt()

            cartas.add(CartaMostro(nombre, nivel, atributo, poder))
        }
    }

    val n = cartas.size

    val grafo = Array(n) { mutableListOf<Int>() }

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (cartas[i].compartenCaracteristica(cartas[j])) {
                grafo[i].add(j)
                grafo[j].add(i)
            }
        }
    }

    for (i in 0 until n) {
        for (j in grafo[i]) {
            for (k in grafo[j]) {
                if (i < k) {
                    println("${cartas[i].obtenerNombre()} ${cartas[j].obtenerNombre()} ${cartas[k].obtenerNombre()}")
                }
            }
        }
    }
}