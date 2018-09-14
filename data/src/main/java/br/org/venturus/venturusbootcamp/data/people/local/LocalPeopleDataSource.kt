package br.org.venturus.venturusbootcamp.data.people.local

import br.org.venturus.venturusbootcamp.domain.people.Person
import io.reactivex.Single

interface LocalPeopleDataSource {

    fun getPeopleList(): Single<List<Person>>

    fun getPerson(personId: String): Single<Person>

    fun savePeopleList(people: List<Person>)
}
