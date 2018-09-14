package venturus.org.br.playground.exercises.collections


data class Person(val name: String, val idade: Int)


fun main(args: Array<String>) {
    val pessoas = listOf(
        Person("Rogério Águas", 80),
        Person("Robert Benício", 40),
        Person("Seu Clécio", 60),
        Person("Tereza", 65),
        Person("Enzo", 5),
        Person("Fausto", 30)
    )
    TODO("Imprimir o nome de todas pessoas com idade suficiente para se aposentar. Use Retirement.java")
}
