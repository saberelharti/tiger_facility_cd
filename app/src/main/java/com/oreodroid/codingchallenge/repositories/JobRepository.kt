package com.oreodroid.codingchallenge.repositories

import androidx.lifecycle.MutableLiveData
import com.oreodroid.codingchallenge.models.Job
import com.oreodroid.codingchallenge.network.RetrofitBuilder
import com.oreodroid.codingchallenge.persistence.JobDao
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.HttpException

class JobRepository(private val jobDao: JobDao) {


    var completableJob: CompletableJob? = null

    fun getJobs(): MutableLiveData<List<Job>> {

        completableJob = Job()

        return object : MutableLiveData<List<Job>>() {

            override fun onActive() {
                super.onActive()

                completableJob?.let { theJob ->

                    CoroutineScope(IO + theJob).launch {

                        try {
                            val response = RetrofitBuilder.apiService.loadListJobs()
                            val responseBody: List<Job>

                            if (response.isSuccessful) {

                                responseBody = response.body().orEmpty()

                                // Delete cached jobs
                                jobDao.deleteAllJobs()

                                // Add the list job
                                jobDao.addJobs(responseBody)

                            } else {

                                responseBody = jobDao.getAllJobs()
                            }

                            withContext(Main) {
                                value = responseBody
                                theJob.complete()
                            }

                        } catch (e: HttpException) {
                            val responseFromCache = jobDao.getAllJobs()
                            withContext(Main) {
                                value = responseFromCache
                                theJob.complete()
                            }
                        } catch (e: Throwable) {
                            val responseFromCache = jobDao.getAllJobs()
                            withContext(Main) {
                                value = responseFromCache
                                theJob.complete()
                            }
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs() {
        completableJob?.cancel()
    }

}