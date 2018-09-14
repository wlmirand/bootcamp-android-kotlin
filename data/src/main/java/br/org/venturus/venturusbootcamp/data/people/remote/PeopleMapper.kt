package br.org.venturus.venturusbootcamp.data.people.remote

import br.org.venturus.venturusbootcamp.domain.people.Person

class PeopleMapper {

    fun mapToPerson(response: PeopleResponse): List<Person> {
        return response.results
            .map { person ->
                Person(person.id).apply {
                    name = person.name
                    email = person.email
                    gender = person.gender
                    birthday = person.birthday
                    phone = person.phone
                    address = person.address
                    pictureUrl = person.pictureUrl
                }
            }
    }
}
