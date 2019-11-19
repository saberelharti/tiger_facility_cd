package com.oreodroid.codingchallenge.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.oreodroid.codingchallenge.R
import com.oreodroid.codingchallenge.viewmodels.JobViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var jobViewModel: JobViewModel
    private lateinit var currentFragment: Fragment
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get progress bar
        progressBar = findViewById(R.id.progressBar)

        // Initialize jobViewModel
        jobViewModel = ViewModelProviders.of(this).get(JobViewModel::class.java)

        // Observe the job list ViewModel
        jobViewModel.getJobList().observe(this, Observer { jobs ->

            if (jobs.isEmpty()) {
                // Show NoResult Fragment
                supportFragmentManager.inTransaction {
                    currentFragment = NoResultFragment()
                    replace(R.id.fragmentContainer, currentFragment)
                }


            } else {
                // Show ListJob Fragment
                supportFragmentManager.inTransaction {
                    currentFragment =
                        ListJobFragment.newInstance(
                            ArrayList(jobs)
                        )
                    replace(R.id.fragmentContainer, currentFragment)
                }
            }

            // Show/Hide progress
            togglePrgressBar()

        })

    }

    override fun onDestroy() {
        super.onDestroy()
        jobViewModel.cancelJobs()
    }

    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

    // Show/Hide progress bar
    private fun togglePrgressBar() {
        if (progressBar.visibility == View.VISIBLE)
            progressBar.visibility = View.INVISIBLE
        else
            progressBar.visibility = View.VISIBLE

    }
}
