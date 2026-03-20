class CartaMostro (
    private val nombre: String,
    private val nivel: Int,
    private val atributo: String,
    private val poder: Int
)

{   init {
        require(nivel in 1..12) { 
            "Error: El nivel de la carta '$nombre' debe estar entre 1 y 12. Valor recibido: $nivel" 
        }
        
        require(poder % 50 == 0) { 
          "Error: El poder de la carta '$nombre' debe ser múltiplo de 50. Valor recibido: $poder" 
        }
        
        val atributosValidos = setOf("AGUA", "FUEGO", "VIENTO", "TIERRA", "LUZ", "OSCURIDAD", "DIVINO")
        require(atributo in atributosValidos) { 
            "Error: El atributo '$atributo' de la carta '$nombre' no es válido." 
        }
    }

fun compartenCaracteristica(otra: CartaMostro): Boolean {
    var coincidencias = 0
    if (this.nivel == otra.nivel) coincidencias++
    if (this.poder == otra.poder) coincidencias++
    if (this.atributo == otra.atributo) coincidencias++

    if (coincidencias == 1) {
        return true
    }

    return false
}

fun obtenerNombre(): String {
    return nombre

}
}