package com.example.dict.repo

import com.example.dict.api.DictApi
import javax.inject.Inject

class DictRepo @Inject constructor(
    private val dictApi: DictApi
) {
    suspend fun getDict() = dictApi.getDict()
    suspend fun login(username:String,password:String) = dictApi.login(username,password)
}
