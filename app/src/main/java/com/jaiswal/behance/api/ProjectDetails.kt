package com.jaiswal.behance.api

import com.jaiswal.behance.models.response.ProjectCompleteResponse
import com.jaiswal.behance.models.response.ProjectDetailsCompleteResponse
import com.jaiswal.behance.models.response.ProjectDetailsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProjectDetails {
    @GET("projects/{id}")
    fun getProjectDetails(
        @Path("id") id: Long = 4889175,
        @Query("api_key") clien_id: String = "1234"
    ): Call<ProjectDetailsCompleteResponse>
}