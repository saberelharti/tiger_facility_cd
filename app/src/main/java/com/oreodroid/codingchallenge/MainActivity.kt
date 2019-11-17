package com.oreodroid.codingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oreodroid.codingchallenge.adapters.JobAdapter
import com.oreodroid.codingchallenge.viewmodels.JobViewModel
import java.io.Console

class MainActivity: AppCompatActivity() {

    private lateinit var jobViewModel: JobViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set up main recycler view
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // set recycler view adapter
        val adapter = JobAdapter()
        recyclerView.adapter = adapter

        // job
        jobViewModel = ViewModelProviders.of(this).get(JobViewModel::class.java)
        jobViewModel.getJobList().observe(this, Observer { jobs ->
            adapter.setJobList(jobs)
            Log.d("JOB LIST SIZE", jobs.size.toString())
        })

    }
}
