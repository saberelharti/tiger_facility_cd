package com.oreodroid.codingchallenge.ui


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.oreodroid.codingchallenge.R
import com.oreodroid.codingchallenge.models.Job
import com.oreodroid.codingchallenge.models.JobModelConverter

class DetailJobActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_job)

        // Get parcelable job object
        val bundle: Bundle? = intent.extras
        val job: Job? = bundle?.getParcelable("job")

        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Job Details"

        // Bind data
        findViewById<TextView>(R.id.customerName).text =
            "Customer Name: %s".format(job?.customerName)
        findViewById<TextView>(R.id.distance).text = "Distance: %s".format(job?.distance)
        findViewById<TextView>(R.id.orderTime).text = "Order Time: %s".format(job?.orderTime)
        findViewById<TextView>(R.id.duration).text = "Duration: %s".format(job?.orderDuration)
        findViewById<TextView>(R.id.extrat).text = "Extras: %s".format(job?.extras)
        findViewById<TextView>(R.id.date).text = "Date: %s".format(job?.jobDate)
        findViewById<TextView>(R.id.paymentMethod).text =
            "Payment Method: %s".format(job?.paymentMethod)
        findViewById<TextView>(R.id.price).text = "Price: %s Euro".format(job?.price)
        findViewById<TextView>(R.id.recurrence).text =
            "Recurrence: %s".format(JobModelConverter.recurrenceMap[job?.recurrency])
        findViewById<TextView>(R.id.location).text = "Location: %s".format(
            JobModelConverter.adequateLocation(
                job?.jobCity,
                job?.jobStreet,
                job?.jobPostalCode.toString()
            )
        )
        findViewById<TextView>(R.id.status).text = "Status: %s".format(job?.status)
    }
}
