package com.oreodroid.codingchallenge.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oreodroid.codingchallenge.models.Job

@Database(entities = [Job::class], version = 1, exportSchema = false)
abstract class JobRoomDatabase : RoomDatabase() {

    abstract fun jobDao(): JobDao

    companion object {

        // Create a unique instance of database opening
        @Volatile
        private var INSTANCE: JobRoomDatabase? = null

        fun getDatabaseInstance(context: Context): JobRoomDatabase {

            val currentInstance = INSTANCE

            if (currentInstance != null)
                return currentInstance

            synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    JobRoomDatabase::class.java,
                    "job_table"
                )
                    .build()

                INSTANCE = newInstance

                return newInstance
            }

        }
    }
}