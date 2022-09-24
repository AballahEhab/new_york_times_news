package com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.models.CriticMovie
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.repository.NewsRepository
import com.abdallah.ehab.newyorktimesnews.utils.Result
import com.abdallah.ehab.newyorktimesnews.utils.ReviewerTypes
import com.abdallah.ehab.newyorktimesnews.utils.api_key
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class NewsHomeViewModel @Inject constructor(private val repository: NewsRepository): ViewModel() {
    private lateinit var _moviesReviewsResult : LiveData<Result<List<CriticMovie>?>>

    val moviesReviewsResult  : LiveData<Result<List<CriticMovie>?>> get() =  _moviesReviewsResult


    init {
        getCriticMovieReviews()
    }

    private fun getCriticMovieReviews(){
        viewModelScope.launch {
            _moviesReviewsResult = repository.getMovieReviews(api_key,
                ReviewerTypes.PICKS.name.lowercase(Locale.getDefault())
            ).asLiveData()
        }
    }
}