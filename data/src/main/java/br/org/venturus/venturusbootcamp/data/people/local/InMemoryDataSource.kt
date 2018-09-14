package br.org.venturus.venturusbootcamp.data.people.local

import br.org.venturus.venturusbootcamp.domain.people.Person
import io.reactivex.Single

class InMemoryDataSource : LocalPeopleDataSource {

    private val cachedPeople = mutableListOf<Person>()

    override fun getPeopleList(): Single<List<Person>> = Single.just(cachedPeople)

    override fun getPerson(personId: String): Single<Person> =
        Single.just(cachedPeople.find { it.id == personId })

    override fun savePeopleList(people: List<Person>) {
        cachedPeople.clear()
        cachedPeople.addAll(people)
    }
}
