package com.jaiswal.behance.models.response

import com.google.gson.annotations.SerializedName

data class Owner(
    @field:SerializedName("first_name")
    val first_name: String? = null,

    @field:SerializedName("last_name")
    val last_name: String? = null,

    @field:SerializedName("images")
    val images: OwnerImages? = null
    )