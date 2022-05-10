package uk.co.planetbeyond.meal_search_clean_architecture.ui.search

import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import uk.co.planetbeyond.domain.api.Resource
import uk.co.planetbeyond.domain.model.Meal
import uk.co.planetbeyond.domain.use_case.SearchMealsUseCase
import uk.co.planetbeyond.meal_search_clean_architecture.base.AppViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMealsUseCase: SearchMealsUseCase
):AppViewModel(){

    private val _mealSearchList = MutableStateFlow<MealSearchState>(MealSearchState())
    val mealSearchList: StateFlow<MealSearchState> = _mealSearchList

    /*fun testLiveData() = liveData<Boolean> {
        emit(true)
        delay(2000)
        emit(false)
    }*/
    fun getSearchMeals(string: String) {
        searchMealsUseCase(string).onEach {
            when(it){
                is Resource.Error -> {
                    _mealSearchList.value = MealSearchState(error = it.message ?: "")
                }
                is Resource.Loading -> {
                    _mealSearchList.value = MealSearchState(isLoading = true)
                }
                is Resource.Success -> {
                    _mealSearchList.value = MealSearchState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    /*fun testSearch(searchString: String) = viewModelScope.launch {
        searchMealsUseCase(searchString).collect {
            when(it){
                is Resource.Error -> {
                    _mealSearchList.value = MealSearchState(error = it.message ?: "")
                }
                is Resource.Loading -> {
                    _mealSearchList.value = MealSearchState(isLoading = true)
                }
                is Resource.Success -> {
                    _mealSearchList.value = MealSearchState(data = it.data)
                }
            }
        }
    }*/

    data class MealSearchState(
        val isLoading: Boolean = false,
        val data: List<Meal>? = null,
        val error: String = ""
    )
}