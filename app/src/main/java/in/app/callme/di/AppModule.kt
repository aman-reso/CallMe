package `in`.app.callme.di

import `in`.app.callme.CallMeApplication
import `in`.app.callme.localDb.dao.UserDao
import `in`.app.callme.localDb.database.AppDatabase
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAppContext(@ApplicationContext application: Context): CallMeApplication {
        return application as CallMeApplication
    }

    @Volatile
    private var INSTANCE: AppDatabase? = null

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(context,
                AppDatabase::class.java,
                "call_me_database").build()
            INSTANCE = instance
            instance
        }
    }

    @Provides
    fun provideChannelDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

}

