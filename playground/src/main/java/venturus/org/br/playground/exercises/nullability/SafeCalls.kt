package venturus.org.br.playground.exercises.nullability

data class GeoPoint(val lat: Float, val long: Float)

data class Address(val street: String, val geopoint: GeoPoint?)

data class Person(val name: String, val address: Address?)

fun sendMissile(geopoint: GeoPoint?) {

    // WHAT THE FUCK!!!!
    //val ret = if (geopoint != null) "Enviando missil para $geopoint" else "Falha ao enviar missil, localização desconhecida!"
    //println(ret)

    when (geopoint) {
        null -> println("Falha ao enviar missil, localização desconhecida!")
        else -> println("Enviando missil para $geopoint")
    }

    /*
    geopoint?.let {
        "Enviando missil para $geopoint"
    } ?: "Falha ao enviar missil, localização desconhecida!"
    */

    /*
    if (geopoint != null) {
        println("Enviando missil para $geopoint")
    } else {
        println("Falha ao enviar missil, localização desconhecida!")
    }
    */
}

fun main(args: Array<String>) {
    val people = listOf(
        Person("Alex", Address("Avenida Brasil", GeoPoint(24.3333f, 27.3333f))),
        Person("Igor", Address("Avenida Orosimbo Maia", null)),
        Person("Rafael", null)
    )

    people.forEach {
        //TODO("Chamar o método 'sendMissiles' para tentar destruir a casa dos instrutores!")
        sendMissile(it.address?.geopoint)
    }
}