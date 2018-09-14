package br.org.venturus.venturusbootcamp.data.people.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object PeopleApiFactory {

    fun createRandomUserApi(isDebug: Boolean): PeopleApi {
        return Retrofit.Builder()
            .baseUrl(PeopleApi.BASE_URL)
            .client(createOkHttpClient(isDebug))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PeopleApi::class.java)
    }

    private fun createOkHttpClient(isDebug: Boolean): OkHttpClient {
        val builder = OkHttpClient.Builder()

        if (isDebug) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(BODY))
        }

        return builder.build()
    }
}
