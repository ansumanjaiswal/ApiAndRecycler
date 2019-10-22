package com.jaiswal.behance.models.response

import com.google.gson.annotations.SerializedName

data class Stats(
    @field:SerializedName("views")
    val views: Long? = null,

    @field:SerializedName("comments")
    val comments: Long? = null,

    @field:SerializedName("appreciations")
    val appreciations: Long? = null )