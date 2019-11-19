package com.oreodroid.codingchallenge.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oreodroid.codingchallenge.models.Job
import com.oreodroid.codingchallenge.persistence.JobRoomDatabase
import com.oreodroid.codingchallenge.repositories.JobRepository

class JobViewModel(application: Application) : AndroidViewModel(application) {


    private val repository: JobRepository
    private var allJobs: MutableLiveData<List<Job>>

    init {
        val jobDao = JobRoomDatabase.getDatabaseInstance(application).jobDao()
        repository = JobRepository(jobDao)
        allJobs = repository.getJobs()
    }


    fun getJobList(): LiveData<List<Job>> {
        return allJobs
    }

    // Cancel coroutines job
    fun cancelJobs() {
        repository.cancelJobs()
    }

}