package `in`.app.callme.viewmodel

import `in`.app.callme.repository.ContactListRepository
import javax.inject.Inject

class UserContactsViewModel @Inject constructor(var contactListRepository: ContactListRepository) {
    fun fetchUserContactsAsync() = contactListRepository.getAllContacts()
}