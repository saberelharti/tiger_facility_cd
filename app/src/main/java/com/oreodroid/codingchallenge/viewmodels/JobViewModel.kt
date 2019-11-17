package com.oreodroid.codingchallenge.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oreodroid.codingchallenge.models.Job
import com.oreodroid.codingchallenge.persistence.JobRoomDatabase
import com.oreodroid.codingchallenge.repositories.JobRepository

class JobViewModel(application: Application): AndroidViewModel(application) {


    private val repository: JobRepository
    private val allJobs: LiveData<List<Job>>

    init {
        val jobDao = JobRoomDatabase.getDatabaseInstance(application, viewModelScope).jobDao()

        repository = JobRepository(jobDao)
        allJobs = repository.allJobs
    }

    fun getJobList(): LiveData<List<Job>> {
        return allJobs
    }

}