package com.jaiswal.behance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.jaiswal.behance.databinding.ActivityMainBinding
import com.jaiswal.behance.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var dataModelAdapter: DataModelAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        viewModel = obtainViewModel(MainActivityViewModel::class.java)
        viewModel.getProjectRemoteRepository().observe(this, Observer {
            Toast.makeText(this, "On Response", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.GONE
            val linearLayoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
            //binding.recyclerView.layoutManager = LinearLayoutManager(this)

            binding.recyclerView.layoutManager = linearLayoutManager
            dataModelAdapter = DataModelAdapter(it)
            //dataModelAdapter.setLoadMore(viewModel)
            binding.recyclerView.adapter = dataModelAdapter
            dataModelAdapter.notifyDataSetChanged()
        })
    }
}
