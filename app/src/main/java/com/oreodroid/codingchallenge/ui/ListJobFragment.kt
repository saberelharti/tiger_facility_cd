package com.oreodroid.codingchallenge.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oreodroid.codingchallenge.R
import com.oreodroid.codingchallenge.adapters.JobAdapter
import com.oreodroid.codingchallenge.adapters.OnItemClickListener
import com.oreodroid.codingchallenge.models.Job


private const val ARG_LIST_JOB = "list_job"


class ListJobFragment : Fragment(), OnItemClickListener {

    private lateinit var myList: ArrayList<Job>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            myList = it.getParcelableArrayList<Job>(ARG_LIST_JOB) as ArrayList<Job>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_job_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // set up main recycler view
        val recyclerView: RecyclerView = view!!.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        // set recycler view adapter
        val adapter = JobAdapter(this)
        recyclerView.adapter = adapter

        // Populate list of jobs
        adapter.setJobList(myList)
    }

    override fun onItemClicked(job: Job) {
        val intent = Intent(activity, DetailJobActivity::class.java)
        intent.putExtra("job", job)
        startActivity(intent)
    }

    companion object {
        fun newInstance(jobs: ArrayList<Job>): ListJobFragment {
            val fragment = ListJobFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_LIST_JOB, ArrayList(jobs))
            fragment.arguments = args
            return fragment
        }
    }

}
