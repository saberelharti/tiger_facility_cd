package com.oreodroid.codingchallenge.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oreodroid.codingchallenge.models.Job

@Dao
interface JobDao {

    // Get All Jobs records
    @Query("SELECT * FROM job_table")
    fun getAllJobs(): LiveData<List<Job>>

    // Insert list of jobs
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addJobs(users: List<Job>)

    // Update list of jobs
    @Update
    suspend fun updateJobs(jobs: List<Job>)

    // Delete all table records
    @Query("DELETE FROM job_table")
    suspend fun deleteAllJobs()

}