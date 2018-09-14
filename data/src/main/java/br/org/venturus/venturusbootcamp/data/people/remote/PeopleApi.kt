package br.org.venturus.venturusbootcamp.data.people.remote

import io.reactivex.Single
import retrofit2.http.GET

interface PeopleApi {

    @GET("users")
    fun getPeople(): Single<PeopleResponse>

    companion object Factory {
        const val BASE_URL = "http://bootcamp.us-east-1.elasticbeanstalk.com/"
    }
}
