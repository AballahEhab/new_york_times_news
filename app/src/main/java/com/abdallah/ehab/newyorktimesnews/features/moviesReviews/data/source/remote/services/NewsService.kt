package com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.source.remote.services

import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.models.CriticMovieResponse
import retrofit2.Response
import retrofit2.http.*

interface NewsService {

    @GET("movies/v2/reviews/{reviewer}.json")
    suspend fun getMoviesReviews(@Path("reviewer") reviewerType:String, @Query("api-key")key: String): Response<CriticMovieResponse>

}