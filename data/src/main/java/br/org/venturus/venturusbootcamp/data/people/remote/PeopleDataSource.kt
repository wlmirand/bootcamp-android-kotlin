package br.org.venturus.venturusbootcamp.data.people.remote

import br.org.venturus.venturusbootcamp.domain.people.Person
import io.reactivex.Single

class PeopleDataSource(
    private val api: PeopleApi,
    private val mapper: PeopleMapper
) : RemotePeopleDataSource {

    override fun getPeople(): Single<List<Person>> {
        return api.getPeople().map { mapper.mapToPerson(it) }
    }
}
