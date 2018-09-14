package venturus.org.br.playground.exercises.nullability

data class RadioStation(
    val nickname: String? = null,
    val name: String? = null
) {

    val preferableName: String
        get() {
            TODO("Retornar nickname se existir, senão retornar name se existir, senão retornar 'Desconhecido'")
        }
}

fun main(args: Array<String>) {
    val stations = listOf(
        RadioStation(),
        RadioStation(name = "Kiss FM"),
        RadioStation(nickname = "Rádio da igreja"),
        RadioStation("Rádio de véio", "CBN")
    )

    stations.forEach {
        println(it.preferableName)
    }
}