package com.jaiswal.behance.api

import com.jaiswal.behance.models.response.ProjectCompleteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Project {
    //q=motorcycle&client_id=VrGyscwt17tBk2BQ9sGHu3f1sYZCa6vI
    @GET("projects?")
    fun getProject(
        @Query("q") query: String = "motorcycle",
        @Query("client_id") clien_id: String = "1234"
    ): Call<ProjectCompleteResponse>
}