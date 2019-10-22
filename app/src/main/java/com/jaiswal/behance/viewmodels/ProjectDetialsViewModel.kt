package com.jaiswal.behance.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jaiswal.behance.models.response.ProjectDetailsResponse
import com.jaiswal.behance.models.response.ProjectResponse
import com.jaiswal.behance.repositories.ProjectDetailsRepositories
import com.jaiswal.behance.repositories.ProjectRepository

class ProjectDetialsViewModel(application: Application) : AndroidViewModel(application){
    fun getProjectDetailsRemoteRepository(): MutableLiveData<ProjectDetailsResponse> {
        return ProjectDetailsRepositories().getProjectData(4889175)
    }
}