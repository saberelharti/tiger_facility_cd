package com.oreodroid.codingchallenge.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oreodroid.codingchallenge.models.Job

@Dao
interface JobDao {

    // Get All Jobs records
    @Query("SELECT * FROM job_table")
    fun getAllJobs(): List<Job>

    // Insert list of jobs
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addJobs(users: List<Job>)

    // Delete all table records
    @Query("DELETE FROM job_table")
    suspend fun deleteAllJobs()

}