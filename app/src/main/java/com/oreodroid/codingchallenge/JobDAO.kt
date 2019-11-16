package com.oreodroid.codingchallenge

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface JobDAO {

    // Get All Jobs records
    @Query("SELECT * FROM job_table")
    fun getAllJobs(): LiveData<List<Job>>

    // Insert list of jobs
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addJobs(users: List<Job>)

    // Update list of jobs
    @Update
    fun updateJobs(jobs: List<Job>)

    // Delete all table records
    @Query("DELETE * FROM job_table")
    fun deletAllJobs()

}