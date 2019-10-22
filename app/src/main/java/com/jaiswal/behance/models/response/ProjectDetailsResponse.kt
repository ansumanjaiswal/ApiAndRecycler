package com.jaiswal.behance.models.response

import com.google.gson.annotations.SerializedName

data class ProjectDetailsResponse(
    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("stats")
    val stats: Stats? = null,

    @field:SerializedName("owners")
    val owners: List<Owner>? = null,

    @field:SerializedName("fields")
    val covers: List<String>? = null
)