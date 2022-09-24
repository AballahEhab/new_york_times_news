package com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.abdallah.ehab.newyorktimesnews.databinding.ItemNewsHomeOverviewBinding
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.data.models.CriticMovie
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.view.NewsHomeFragmentDirections

class NewsHomeAdapter : RecyclerView.Adapter<NewsHomeAdapter.NewsCardViewHolder>() {

    var dataList: List<CriticMovie> = listOf()

    class NewsCardViewHolder constructor(val binding: ItemNewsHomeOverviewBinding) :
        ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCardViewHolder =
        NewsCardViewHolder(
            ItemNewsHomeOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: NewsCardViewHolder, position: Int) {
        val movie = dataList[position]

        holder.binding.movieReview = movie

        holder.binding.root.setOnClickListener {
            it.findNavController().navigate(
                NewsHomeFragmentDirections.actionNewsHomeFragmentToNewsDetailsFragment(
                    movie = movie
                )
            )
        }
    }

    override fun getItemCount(): Int = dataList.size

}