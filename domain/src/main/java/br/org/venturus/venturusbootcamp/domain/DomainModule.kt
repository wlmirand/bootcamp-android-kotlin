package br.org.venturus.venturusbootcamp.domain

import br.org.venturus.venturusbootcamp.domain.people.GetPeopleUseCase
import org.koin.dsl.module.module

val domainModule = module {
    single { GetPeopleUseCase(get()) }
}