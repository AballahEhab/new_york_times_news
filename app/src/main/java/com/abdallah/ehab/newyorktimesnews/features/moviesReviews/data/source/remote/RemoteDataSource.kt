package com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.source.remote

import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.models.CriticMovieResponse
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.source.remote.services.NewsService
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val newsService: NewsService) {

    suspend fun getMovieReviews(key: String, reviewerType: String) =
        flow {
            emit(newsService.getMoviesReviews(reviewerType, key))
        }

}