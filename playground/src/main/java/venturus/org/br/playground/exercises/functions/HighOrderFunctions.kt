package venturus.org.br.playground.exercises.functions

import java.util.Random

data class Person(val name: String, val age: Int)

fun populate(count: Int, createPersonFunc: (Int) -> Person): List<Person> {
    val people = mutableListOf<Person>()

    val randomGen = Random()

    for (i in 1..count) {
        people.add(createPersonFunc(randomGen.nextInt(count)))
    }

    return people
}

fun main(args: Array<String>) {
    val people = mutableListOf<Person>()

    TODO("Use o método populate para criar uma lista de pessoas")

    people.forEach { println(it) }
}
