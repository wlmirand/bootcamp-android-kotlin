package venturus.org.br.playground.exercises.stdlib

import java.util.Random

class Calculator {

    var calculus = 0

    fun calculate(): Int {
        calculus = Random().nextInt(100)
        return calculus
    }

    fun recalculate() = 2 * calculus
}

class Pencil {
    fun writePaper() {
        println("Writing paper...")
    }
}

class Scientist {

    var calculator: Calculator? = null

    var pencil: Pencil? = null

    fun makeScience() {

        var scienceCalculus = 0

        //TODO Refatore este bloco de código com o 'let' para evitar chamar `!!`
        calculator?.let {
            scienceCalculus += it.calculate()
            scienceCalculus += it.recalculate()
        }
        /*
        if (calculator != null) {
            scienceCalculus = calculator!!.calculate()
            scienceCalculus += calculator!!.recalculate()
        }
        */

        println("EUREKA!!!! $scienceCalculus")

        pencil?.writePaper()
    }
}

fun main(args: Array<String>) {
    //TODO Refatore este bloco de código com o 'apply' ou 'with' para evitar chamar scientist repetidamente
    val scientist = Scientist().apply {
        calculator = Calculator()
        pencil = Pencil()
        //makeScience()
    }
    scientist.makeScience()

    val scientist2 = with(Scientist()) {
        calculator = Calculator()
        pencil = Pencil()
        makeScience()
        //this
    }
}