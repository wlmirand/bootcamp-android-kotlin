package br.org.venturus.venturusbootcamp.data.people.remote

import com.google.gson.annotations.SerializedName

data class PeopleResponse(
    @SerializedName("results")
    val results: List<People>
)

data class People(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("dob") val birthday: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("address") val address: String?,
    @SerializedName("picture") val pictureUrl: String?
)
