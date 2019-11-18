package com.oreodroid.codingchallenge.network

import com.oreodroid.codingchallenge.models.Job
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("jobs")
    suspend fun loadListJobs(): Response<List<Job>>
}