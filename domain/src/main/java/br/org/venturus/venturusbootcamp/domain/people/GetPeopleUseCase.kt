package br.org.venturus.venturusbootcamp.domain.people

import io.reactivex.Single

class GetPeopleUseCase(private val peopleRepository: PeopleRepository) {

    fun getPeopleList(): Single<List<Person>> =
        peopleRepository.getPeopleList()

    fun getPerson(personId: String): Single<Person> =
        peopleRepository.getPerson(personId)
}
