package br.org.venturus.venturusbootcamp.data.people

import br.org.venturus.venturusbootcamp.data.people.local.LocalPeopleDataSource
import br.org.venturus.venturusbootcamp.data.people.remote.RemotePeopleDataSource
import br.org.venturus.venturusbootcamp.domain.people.PeopleRepository
import br.org.venturus.venturusbootcamp.domain.people.Person
import io.reactivex.Single

class PeopleRepositoryImpl(
    private val localPeopleDataSource: LocalPeopleDataSource,
    private val remotePeopleDataSource: RemotePeopleDataSource
) : PeopleRepository {

    override fun getPeopleList(): Single<List<Person>> =
        localPeopleDataSource.getPeopleList().flatMap {
            if (it.isEmpty()) {
                remotePeopleDataSource.getPeople()
                    .doOnSuccess { list -> localPeopleDataSource.savePeopleList(list) }
            } else {
                Single.just(it)
            }
        }

    override fun getPerson(personId: String): Single<Person> =
        localPeopleDataSource.getPerson(personId)
}
