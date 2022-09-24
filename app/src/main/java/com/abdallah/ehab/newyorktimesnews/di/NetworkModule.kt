package com.abdallah.ehab.newyorktimesnews.di

import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.source.remote.services.NewsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitObj(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.nytimes.com/svc/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideAuthService(retrofitObj:Retrofit): NewsService = retrofitObj.create(NewsService::class.java)



}