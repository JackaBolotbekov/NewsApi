package com.example.bottomnavigationapi.data.models

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("totalResults")
    val totalResults: Int = 0,
    @SerializedName("articles")
    val articles: List<T>,
    @SerializedName("status")
    val status: String = ""
)