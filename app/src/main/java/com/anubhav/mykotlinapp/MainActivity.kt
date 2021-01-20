package com.anubhav.mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.anubhav.mykotlinapp.databinding.ActivityMainBinding
import com.anubhav.mykotlinapp.uimodels.OnItemClickListener
import com.anubhav.mykotlinapp.uimodels.Repository

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val repositoryAdapter = RepositoryAdapter(arrayListOf(), this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = repositoryAdapter
        viewModel.repositories.observe(this,
            Observer<ArrayList<Repository>> { it?.let{ repositoryAdapter.replaceData(it)} })

    }

    override fun onItemClick(position: Int) {
        TODO("not implemented")
    }
}