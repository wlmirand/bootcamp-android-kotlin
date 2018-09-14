package br.org.venturus.venturusbootcamp.data

import br.org.venturus.venturusbootcamp.data.people.PeopleRepositoryImpl
import br.org.venturus.venturusbootcamp.data.people.local.InMemoryDataSource
import br.org.venturus.venturusbootcamp.data.people.local.LocalPeopleDataSource
import br.org.venturus.venturusbootcamp.data.people.remote.PeopleApiFactory
import br.org.venturus.venturusbootcamp.data.people.remote.PeopleDataSource
import br.org.venturus.venturusbootcamp.data.people.remote.PeopleMapper
import br.org.venturus.venturusbootcamp.data.people.remote.RemotePeopleDataSource
import br.org.venturus.venturusbootcamp.domain.people.PeopleRepository
import org.koin.dsl.module.module

val dataModule = module {

    single { InMemoryDataSource() as LocalPeopleDataSource }

    single { PeopleApiFactory.createRandomUserApi(true) }

    factory { PeopleMapper() }

    single { PeopleDataSource(get(), get()) as RemotePeopleDataSource }

    single { PeopleRepositoryImpl(get(), get()) as PeopleRepository }
}
