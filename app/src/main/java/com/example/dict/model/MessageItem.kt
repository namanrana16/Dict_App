package com.example.dict.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MessageItem(
    @Json(name = "agent_id")
    val agentId: String?,
    @Json(name = "body")
    val body: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "thread_id")
    val threadId: Int?,
    @Json(name = "timestamp")
    val timestamp: String?,
    @Json(name = "user_id")
    val userId: String?
)