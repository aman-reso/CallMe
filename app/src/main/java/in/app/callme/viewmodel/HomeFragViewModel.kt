package `in`.app.callme.viewmodel

import `in`.app.callme.di.GlobalNetworkResponse
import `in`.app.callme.repository.HomeFragRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragViewModel @Inject constructor(var repository: HomeFragRepository) : ViewModel() {

    fun get() = viewModelScope.launch {
        val response = repository.getResponse()
        when(response)
        {
            is GlobalNetworkResponse.Success<*> ->{

            }
            else -> {

            }
        }
    }
}