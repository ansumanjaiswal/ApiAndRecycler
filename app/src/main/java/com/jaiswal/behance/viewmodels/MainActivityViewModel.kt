package com.jaiswal.behance.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jaiswal.behance.models.response.ProjectResponse
import com.jaiswal.behance.repositories.ProjectRepository

class MainActivityViewModel(application: Application): AndroidViewModel(application) {

    fun getProjectRemoteRepository(): MutableLiveData<List<ProjectResponse>>{
        return ProjectRepository().getProjectData()
    }
}