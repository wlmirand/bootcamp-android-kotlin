package br.org.venturus.venturusbootcamp.data.people.remote

import br.org.venturus.venturusbootcamp.domain.people.Person
import io.reactivex.Single

interface RemotePeopleDataSource {

    fun getPeople(): Single<List<Person>>
}
