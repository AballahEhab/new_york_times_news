package com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.viewModel

import androidx.lifecycle.ViewModel
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.models.CriticMovie
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.repository.NewsRepository
import javax.inject.Inject

class DetailedNewsViewModel @Inject constructor(): ViewModel() {

    lateinit var movie :CriticMovie
}