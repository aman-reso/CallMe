package `in`.app.callme.repository

import `in`.app.callme.localDb.dao.UserDao
import `in`.app.callme.localDb.models.UserContacts
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ContactListRepository @Inject constructor(var userDao: UserDao) {
    fun getAllContacts() = userDao.getAllDistinctContactsFromDB()

  suspend  fun insertUserContactsIntoDb(userContacts: List<UserContacts>) {
        userDao.insertValue(user = userContacts)
    }

}