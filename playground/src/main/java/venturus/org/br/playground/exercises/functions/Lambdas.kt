package venturus.org.br.playground.exercises.functions

class Adapter {

    var onItemClickListener: ((position: Int) -> Unit)? = null

    fun click(position: Int) {
        onItemClickListener?.invoke(position)
    }
}

fun main(args: Array<String>) {
    val adapter = Adapter()

    TODO("Crie um lambda que imprima a posição clicada e o atribua no adapter")

    adapter.click(1)
    adapter.click(3)
}