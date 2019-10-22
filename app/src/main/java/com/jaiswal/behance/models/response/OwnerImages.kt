package com.jaiswal.behance.models.response

import com.google.gson.annotations.SerializedName

data class OwnerImages(
    @field:SerializedName("50")
    val image_50: String? = null,

    @field:SerializedName("100")
    val image_100: String? = null,

    @field:SerializedName("115")
    val image_115: String? = null,

    @field:SerializedName("230")
    val image_230: String? = null,

    @field:SerializedName("138")
    val image_138: String? = null,

    @field:SerializedName("276")
    val image_276: String? = null
)