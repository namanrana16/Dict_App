package com.example.dict.model.di

import com.example.dict.api.ApiConstants.BASE_URL
import com.example.dict.api.DictApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DictModule {

    @Provides
    @Singleton
fun provideDictApi(builder:Retrofit.Builder):DictApi{

        return builder.baseUrl(BASE_URL)
            .build()
            .create(DictApi::class.java)
    }


    @Provides
    @Singleton

    fun provideRetrofit():Retrofit.Builder{
        return Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
    }


}