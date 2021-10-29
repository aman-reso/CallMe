package `in`.app.callme.api.interfaces

import retrofit2.Response
import retrofit2.http.GET

interface BasicInterface {
    @GET("/posts")
    suspend fun getCountries(): Response<Any>
}