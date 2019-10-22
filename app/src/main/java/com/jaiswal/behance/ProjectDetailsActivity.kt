package com.jaiswal.behance

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.jaiswal.behance.databinding.ActivityProjectDetailsBinding
import com.jaiswal.behance.viewmodels.ProjectDetialsViewModel

class ProjectDetailsActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityProjectDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_project_details)
        val viewmodel = obtainViewModel(ProjectDetialsViewModel::class.java)
        viewmodel.getProjectDetailsRemoteRepository().observe(this, Observer {
            Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show()
            binding.appreciations.text = it.stats!!.appreciations.toString()
            binding.description.text = it.description
            binding.field1.text = it.covers!![0]
            //binding.appreciations.text = it.stats.appreciations.toString()
            val imageUrl: String? = it.owners!![0].images!!.image_100
            Glide.with(this)
                .load(imageUrl)
                //.placeholder(R.drawable.defaultImage)
                //.error(R.drawable.errorImage)
                .into(binding.imageView)

        })

    }
}