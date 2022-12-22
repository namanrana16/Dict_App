package com.example.dict.api

import com.example.dict.model.Dict
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface DictApi {

    @Headers("Authorization: Token 78bb251553954d4c34a988e991e28ed8a6be322f")
    @GET("{word}")
    suspend fun getDict( @Path("word") word: String): Response<Dict>
}