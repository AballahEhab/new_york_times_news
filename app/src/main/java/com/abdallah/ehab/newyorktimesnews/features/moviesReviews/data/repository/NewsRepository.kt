package com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.repository

import com.abdallah.ehab.newyorktimesnews.utils.Result.*
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.source.remote.RemoteDataSource
import kotlinx.coroutines.flow.map
import javax.inject.Inject



class NewsRepository @Inject constructor(private val remoteSource: RemoteDataSource) {

     suspend fun getMovieReviews(key: String, reviewerType: String) =
        remoteSource.getMovieReviews(key,reviewerType).map { responce ->
            if(responce.isSuccessful)
                Success(responce.body()?.results)
            else
                Error(responce.message())
        }




}