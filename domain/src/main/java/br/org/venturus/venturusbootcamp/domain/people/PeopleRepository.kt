package br.org.venturus.venturusbootcamp.domain.people

import io.reactivex.Single

interface PeopleRepository {

    fun getPeopleList(): Single<List<Person>>

    fun getPerson(personId: String): Single<Person>
}
