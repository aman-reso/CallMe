package `in`.app.callme.localDb.dao

import `in`.app.callme.localDb.models.UserContacts
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertValue(user: UserContacts)

    @Query("select *from user_table")
    fun getAllQuery(): Flow<List<UserContacts>>
}