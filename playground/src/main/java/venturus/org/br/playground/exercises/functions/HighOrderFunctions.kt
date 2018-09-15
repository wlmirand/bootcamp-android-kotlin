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

private fun criaPessoa(a: Int) : Person {
    return Person("aaa", a)
}

fun main(args: Array<String>) {
    val people = populate(5, createPersonFunc = { criaPessoa(it) } )

    people.forEach { println(it) }
}
