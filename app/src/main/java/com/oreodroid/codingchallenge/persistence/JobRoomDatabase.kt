package com.oreodroid.codingchallenge.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.oreodroid.codingchallenge.models.Job
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Job::class], version = 1, exportSchema = false)
abstract class JobRoomDatabase: RoomDatabase() {

    abstract fun jobDao(): JobDao

    private class JobDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var jobDao = database.jobDao()

                    // Delete all content here.
                    jobDao.deleteAllJobs()


                    // Add sample words.
                    var job = Job(    12,
                    "testUser",
                    1.885938875621,
                    "2016-03-04T00:00:00.000Z",
                    "oven",
                    2.0,
                    "dc4n47ggy",
                    "16:00",
                    "Cash",
                    33.50,
                    7,
                    "Berlin",
                    52.5130435,
                    13.4180222,
                    12047,
                    "bruckenstrasse 5a",
                    "FULFILLED")

                    var job1 = Job(    13,
                        "testUser",
                        1.885938875621,
                        "2016-03-04T00:00:00.000Z",
                        "oven",
                        2.0,
                        "dc4n47ggy",
                        "16:00",
                        "Cash",
                        33.50,
                        7,
                        "Berlin",
                        52.5130435,
                        13.4180222,
                        12047,
                        "bruckenstrasse 5a",
                        "FULFILLED")

                    jobDao.addJobs(listOf( job, job1))
                }
            }
        }
    }

    companion object {

        // Create a unique instance of database opening
        @Volatile
        private var INSTANCE : JobRoomDatabase? = null

        fun getDatabaseInstance(context: Context, scope: CoroutineScope): JobRoomDatabase {

            val currentInstance = INSTANCE

            if(currentInstance != null)
                return currentInstance

            synchronized(this) {
                val newInstance = Room.databaseBuilder(
                        context.applicationContext,
                        JobRoomDatabase::class.java,
                        "job_table"
                    )
                    .addCallback(JobDatabaseCallback(scope))
                    .build()

                INSTANCE = newInstance

                return newInstance
            }

        }
    }
}