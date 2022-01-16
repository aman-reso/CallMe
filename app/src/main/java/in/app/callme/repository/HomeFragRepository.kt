package `in`.app.callme.repository

import `in`.app.callme.di.GlobalNetworkResponse
import `in`.app.callme.api.interfaces.BasicInterface
import `in`.app.callme.api.interfaces.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HomeFragRepository @Inject constructor(private var service: BasicInterface) {
    suspend fun getResponse(): GlobalNetworkResponse<Response<Any>> {
        return safeApiCall {
            withContext(Dispatchers.IO) {
                service.getCountries()
            }
        }
    }
}