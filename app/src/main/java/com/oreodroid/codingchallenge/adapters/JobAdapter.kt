package com.oreodroid.codingchallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oreodroid.codingchallenge.R
import com.oreodroid.codingchallenge.models.Job

class JobAdapter(private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<JobHolder>() {

    private var jobList: List<Job> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobHolder {
        // return
        return JobHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_job_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        // return the size of job list
        return jobList.size
    }

    override fun onBindViewHolder(holder: JobHolder, position: Int) {
        // Bind data to the view holder
        holder.bindData(jobList[position], itemClickListener)
    }

    // Set the list of job and notify changes
    fun setJobList(jobList: List<Job>) {
        this.jobList = jobList
        notifyDataSetChanged()
    }
}

interface OnItemClickListener {
    fun onItemClicked(job: Job)
}