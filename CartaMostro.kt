class CartaMostro(
    val nombre: String,
    val nivel: Int,
    val atributo: String,
    val poder: Int
) {
    init {
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
}