package com.jaiswal.behance.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Behance {
    companion object {

        private var retrofit: Retrofit? = null

        val client: Retrofit
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(" https://api.behance.net/v2/")
                        .build()
                }
                return retrofit!!
            }
    }
}