package com.example.dict.api

import com.example.dict.model.Auth
import com.example.dict.model.MessageItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface DictApi {

    @Headers("X-Branch-Auth-Token:neawY8rXeHJG0b5NspuXMQ")
    @GET("api/messages")
    suspend fun getDict(): Response<List<MessageItem>>

    @POST("api/login")
    suspend fun login(@Query("username") username:String,@Query("password") password:String  ): Response<Auth>
}