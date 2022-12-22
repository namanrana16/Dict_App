package com.example.dict.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Dict(
    @Json(name = "definitions")
    val definitions: List<Definition>,
    @Json(name = "pronunciation")
    val pronunciation: String,
    @Json(name = "word")
    val word: String
)