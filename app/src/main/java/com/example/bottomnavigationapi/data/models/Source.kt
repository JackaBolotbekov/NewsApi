package com.example.bottomnavigationapi.data.models

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: String = ""
)