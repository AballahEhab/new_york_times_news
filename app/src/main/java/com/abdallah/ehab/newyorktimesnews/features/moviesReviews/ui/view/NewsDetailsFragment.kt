package com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.abdallah.ehab.newyorktimesnews.NewYorkApplication
import com.abdallah.ehab.newyorktimesnews.R
import com.abdallah.ehab.newyorktimesnews.databinding.FragmentNewsDetailsBinding
import com.abdallah.ehab.newyorktimesnews.databinding.FragmentNewsHomeBinding
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.viewModel.DetailedNewsViewModel
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.viewModel.NewsHomeViewModel
import javax.inject.Inject


class NewsDetailsFragment : Fragment() {

    @Inject
    lateinit var viewModel: DetailedNewsViewModel

    lateinit var binding: FragmentNewsDetailsBinding

    val args: NewsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsDetailsBinding.inflate(inflater,container,false)

        (context?.applicationContext as NewYorkApplication).appComponent.injectNewsDetailsFragmentFields(this)


        viewModel.movie = args.movie

        binding.movieReview = viewModel.movie


        return binding.root
    }
}