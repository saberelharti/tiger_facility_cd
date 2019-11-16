package com.oreodroid.codingchallenge.repositories

import androidx.lifecycle.LiveData
import com.oreodroid.codingchallenge.persistence.JobDao
import com.oreodroid.codingchallenge.models.Job

class JobRepository(private val jobDao: JobDao) {

    val allJobs: LiveData<List<Job>> = jobDao.getAllJobs()

}