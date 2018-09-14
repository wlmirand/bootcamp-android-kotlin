package br.org.venturus.venturusbootcamp.domain.people

data class Person(
    val id: String,
    var name: String? = null,
    var email: String? = null,
    var gender: String? = null,
    var birthday: String? = null,
    var phone: String? = null,
    var address: String? = null,
    var pictureUrl: String? = null
) {
    companion object {
        const val GENDER_MALE = "masculino"
        const val GENDER_FEMALE = "feminino"
    }
}
