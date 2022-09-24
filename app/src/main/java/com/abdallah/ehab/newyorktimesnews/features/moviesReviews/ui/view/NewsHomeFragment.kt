package com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.abdallah.ehab.newyorktimesnews.NewYorkApplication
import com.abdallah.ehab.newyorktimesnews.databinding.FragmentNewsHomeBinding
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.adapters.NewsHomeAdapter
import com.abdallah.ehab.newyorktimesnews.features.moviesReviews.ui.viewModel.NewsHomeViewModel
import com.abdallah.ehab.newyorktimesnews.utils.isVisible
import javax.inject.Inject


class NewsHomeFragment : Fragment() {

    @Inject
    lateinit var newsHomeViewModel: NewsHomeViewModel

    private lateinit var binding: FragmentNewsHomeBinding

    private lateinit var adapter: NewsHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsHomeBinding.inflate(inflater, container, false)

        (context?.applicationContext as NewYorkApplication).appComponent.injectNewsDetailsFragmentFields(
            this
        )

        initRecyclerView()

        newsHomeViewModel.moviesReviewsResult.observe(viewLifecycleOwner) {
            it.handleRepoResponse(
                onLoading = {
                    showProgressBar()
                },
                onError = {
                    hideProgressBar()
                },
                onSuccess = {
                    hideProgressBar()
                    adapter.dataList = it.data!!
                    binding.moviesRecyclerV.adapter = adapter
                },
            )
        }
        return binding.root

    }

    private fun initRecyclerView() {
        adapter = NewsHomeAdapter()


        binding.moviesRecyclerV.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.moviesRecyclerV.adapter = adapter
    }

    private fun showProgressBar() = binding.progressBar.isVisible(true)

    private fun hideProgressBar() = binding.progressBar.isVisible(false)


}