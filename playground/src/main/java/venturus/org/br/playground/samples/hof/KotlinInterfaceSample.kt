package venturus.org.br.playground.samples.hof

fun main(args: Array<String>) {

    val listener = object : JavaListener {
        override fun printNumber(number: Int) {
            print("Found $number")
        }
    }

    findNumber(listener)
}

private fun findNumber(listener: JavaListener) {
    listener.printNumber(108)
}

interface JavaListener {
    fun printNumber(number: Int)
}
