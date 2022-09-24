package com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.models

import android.R.bool
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CriticMovieResponse (
    val status:String?,
    val copyright:String?,
    val num_results:Int?,
    @Expose
    val results:List<CriticMovie>?,
        )