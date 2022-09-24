package com.abdallah.ehab.newyorktimesnews.di

import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.repository.NewsRepository
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.view.NewsDetailsFragment
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.view.NewsHomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun repository(): NewsRepository

    fun injectNewsDetailsFragmentFields(Fragment: NewsHomeFragment)

    fun injectNewsDetailsFragmentFields(Fragment: NewsDetailsFragment)


}