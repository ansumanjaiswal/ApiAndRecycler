package com.jaiswal.behance.models.response

import com.google.gson.annotations.SerializedName

data class ProjectDetailsCompleteResponse(
    @field:SerializedName("http_code")
    val http_code: Int? = null,

    @field:SerializedName("project")
    val projects: ProjectDetailsResponse? = null
)