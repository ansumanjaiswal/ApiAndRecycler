package com.jaiswal.behance.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jaiswal.behance.api.Behance

import com.jaiswal.behance.api.ProjectDetails
import com.jaiswal.behance.models.response.ProjectDetailsCompleteResponse
import com.jaiswal.behance.models.response.ProjectDetailsResponse
import com.jaiswal.behance.models.response.ProjectResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectDetailsRepositories {
    private val mutableLiveData = MutableLiveData<ProjectDetailsResponse>()
    private var apiClient: ProjectDetails? = null

    fun getProjectData(id: Long): MutableLiveData<ProjectDetailsResponse> {
        apiClient = Behance.client.create(ProjectDetails::class.java)

        val call = apiClient?.getProjectDetails(id = id)


        call?.enqueue(object : Callback<ProjectDetailsCompleteResponse> {

            override fun onFailure(call: Call<ProjectDetailsCompleteResponse>?, t: Throwable?) {
                Log.d("Failure", t.toString())
            }

            override fun onResponse(call: Call<ProjectDetailsCompleteResponse>?, response: Response<ProjectDetailsCompleteResponse>?) {
                if (response?.isSuccessful!!) {

                    mutableLiveData.postValue(response.body()!!.projects!!)

                }
            }
        })
        return mutableLiveData
    }
}