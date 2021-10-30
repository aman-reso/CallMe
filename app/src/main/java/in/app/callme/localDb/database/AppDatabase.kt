package `in`.app.callme.localDb.database

import `in`.app.callme.localDb.dao.UserDao
import `in`.app.callme.localDb.models.UserContacts
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserContacts::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

