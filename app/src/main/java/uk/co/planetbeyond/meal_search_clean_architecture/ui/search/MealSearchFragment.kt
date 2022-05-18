package uk.co.planetbeyond.meal_search_clean_architecture.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import uk.co.planetbeyond.meal_search_clean_architecture.R
import uk.co.planetbeyond.meal_search_clean_architecture.base.AppFragment
import uk.co.planetbeyond.meal_search_clean_architecture.databinding.FragmentMealSearchBinding

@AndroidEntryPoint
class MealSearchFragment : AppFragment<FragmentMealSearchBinding>(FragmentMealSearchBinding::inflate) {

    private val searchAdapter = MealSearchAdapter()

    private val viewModel: SearchViewModel by viewModels()

    /*private var _binding: FragmentMealSearchBinding? = null
    val binding: FragmentMealSearchBinding
        get() = _binding!!*/


    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealSearchBinding.inflate(inflater, container, false)
        return _binding?.root
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        /*viewModel.testLiveData().observe(viewLifecycleOwner){
            if(it){

            }
        }*/
        binding.mealSearchRecycler.apply {
            adapter = searchAdapter
        }

        binding.mealSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String?): Boolean {
                s?.let {
                    viewModel.getSearchMeals(it)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })

        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.mealSearchList.collect {
                if (it.isLoading) {
                    binding.nothingFound.visibility = View.GONE
                    binding.progressMealSearch.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.nothingFound.visibility = View.GONE
                    binding.progressMealSearch.visibility = View.GONE
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }

                it.data?.let {

                    if (it.isEmpty()) {
                        binding.nothingFound.visibility = View.VISIBLE
                    }
                    binding.progressMealSearch.visibility = View.GONE
                    searchAdapter.setContentList(it.toMutableList())
                }


            }
        }

        searchAdapter.itemClickListener {
            val bundle = bundleOf("meal_id" to it.id)
            findNavController().navigate(
                R.id.mealDetailsFragment,bundle

            )
        }
    }
}