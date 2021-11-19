package `in`.app.callme.localDb.dao

import `in`.app.callme.localDb.models.UserContacts
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertValue(user: List<UserContacts>)

    @Query("select *from user_table")
    fun getAllContactsFromDB(): Flow<List<UserContacts>>

    @Query(" select *from user_table group by mobile_number order by contact_name collate nocase asc " )
     fun getAllDistinctContactsFromDB():Flow<List<UserContacts>>

//    @Query("drop table user_table ")
//    suspend fun deleteCompleteUContactTable()
}