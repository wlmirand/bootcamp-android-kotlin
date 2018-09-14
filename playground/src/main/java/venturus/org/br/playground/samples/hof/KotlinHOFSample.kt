package venturus.org.br.playground.samples.hof

import java.util.Random

fun main(args: Array<String>) {

    findNumber { number ->
        println("Found $number")
    }

    findRandomNumber(10) { number ->
        println("Found $number")
    }
}

private fun findNumber(listener: (number: Int) -> Unit) = listener(108)

private fun findRandomNumber(
    maxRandom: Int,
    func: (number: Int) -> Unit
) {
    val max = Random().nextInt(maxRandom)
    func(max)
}
