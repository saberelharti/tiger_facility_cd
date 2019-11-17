package com.oreodroid.codingchallenge.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oreodroid.codingchallenge.R
import com.oreodroid.codingchallenge.models.Job
import kotlinx.android.synthetic.main.recyclerview_job_item.view.*

class JobHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val orderTime: TextView = itemView.findViewById(R.id.orderTime)
    private val customerName: TextView = itemView.findViewById(R.id.customerName)
    private val duration: TextView = itemView.findViewById(R.id.duration)
    private val recurrence: TextView = itemView.findViewById(R.id.recurrence)
    private val price: TextView = itemView.findViewById(R.id.price)
    private val status: TextView = itemView.findViewById(R.id.status)
    private val jobLocation: TextView = itemView.findViewById(R.id.location)

    // Bind data to the item view
    fun bindData(job: Job) {
        orderTime.text = job.orderTime.toString()
        customerName.text = job.customerName
        duration.text = job.distance.toString()
        recurrence.text = job.recurrency.toString()
        price.text = job.price.toString()
        status.text = job.status
        jobLocation.text = "${job.jobCity} | ${job.jobStreet}, ${job.jobPostalCode}"
    }


}