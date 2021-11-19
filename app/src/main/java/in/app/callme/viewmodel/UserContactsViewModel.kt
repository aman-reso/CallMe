package `in`.app.callme.viewmodel

import `in`.app.callme.localDb.models.UserContacts
import `in`.app.callme.repository.ContactListRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserContactsViewModel @Inject constructor(var contactListRepository: ContactListRepository) : ViewModel() {
    fun fetchUserContactsAsync() = contactListRepository.getAllContacts()
    fun insertUserContacts(userContacts: List<UserContacts>) =
        viewModelScope.launch(Dispatchers.IO) {
            contactListRepository.insertUserContactsIntoDb(userContacts = userContacts)
        }
    fun deleteAllUserContacts(){

    }

}