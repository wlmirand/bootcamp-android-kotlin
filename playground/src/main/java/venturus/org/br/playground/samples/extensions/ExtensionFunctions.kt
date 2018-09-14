package venturus.org.br.playground.samples.extensions

fun String.toCamelCase(): String {
    val upperCasedChar = get(0).toUpperCase()
    return replaceRange(0, 1, upperCasedChar.toString())
}

fun main(args: Array<String>) {

    println("lalaland".toCamelCase())
}