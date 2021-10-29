package `in`.app.callme.localDb.database

import `in`.app.callme.localDb.dao.UserDao
import `in`.app.callme.localDb.models.User
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

