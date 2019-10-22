package com.jaiswal.behance.models.response

import com.google.gson.annotations.SerializedName

data class ProjectCompleteResponse(
    @field:SerializedName("http_code")
    val http_code: Int? = null,

    @field:SerializedName("projects")
    val projects: List<ProjectResponse>? = null
)