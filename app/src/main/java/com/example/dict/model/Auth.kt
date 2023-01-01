package com.example.dict.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Auth(
    @Json(name = "auth_token")
    val authToken: String
)