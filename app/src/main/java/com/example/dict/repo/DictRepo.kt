package com.example.dict.repo

import com.example.dict.api.DictApi
import javax.inject.Inject

class DictRepo @Inject constructor(
    private val dictApi: DictApi
) {
    suspend fun getDict(word: String) = dictApi.getDict(word)
}
