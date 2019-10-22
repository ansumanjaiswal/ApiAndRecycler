package com.jaiswal.behance.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jaiswal.behance.api.Behance
import com.jaiswal.behance.api.Project
import com.jaiswal.behance.models.response.ProjectCompleteResponse
import com.jaiswal.behance.models.response.ProjectResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectRepository {

    private val mutableLiveData = MutableLiveData<List<ProjectResponse>>()
    private var apiClient: Project? = null

    fun getProjectData(): MutableLiveData<List<ProjectResponse>>{
        apiClient = Behance.client.create(Project::class.java)

        val call = apiClient?.getProject()


        call?.enqueue(object : Callback<ProjectCompleteResponse> {
            override fun onFailure(call: Call<ProjectCompleteResponse>?, t: Throwable?) {
                Log.d("Failure", t.toString())
            }

            override fun onResponse(call: Call<ProjectCompleteResponse>?, response: Response<ProjectCompleteResponse>?) {
                if (response?.isSuccessful!!) {

                    /*val data: List<FiveWeekChartPoint> = convertData(response.body())
                    insertData(data)
                    mutableLiveData.postValue(data)*/

                    if(response.body()!!.projects!!.isNotEmpty()){
                        mutableLiveData.postValue(response.body()!!.projects!!)
                    }
                }
            }
        })
        return mutableLiveData
    }

}
