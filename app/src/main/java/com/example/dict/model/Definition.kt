package com.example.dict.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Definition(
    @Json(name = "definition")
    val definition: String,
    @Json(name = "emoji")
    val emoji: String?,
    @Json(name = "example")
    val example: String?,
    @Json(name = "image_url")
    val imageUrl: String?,
    @Json(name = "type")
    val type: String
)