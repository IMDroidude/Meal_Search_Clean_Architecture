package uk.co.planetbeyond.meal_search_clean_architecture.ui.search

import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import uk.co.planetbeyond.domain.api.Resource
import uk.co.planetbeyond.domain.api.State
import uk.co.planetbeyond.domain.model.Meal
import uk.co.planetbeyond.domain.use_case.SearchMealsUseCase
import uk.co.planetbeyond.meal_search_clean_architecture.base.AppViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMealsUseCase: SearchMealsUseCase
):AppViewModel(){

    /*private val _mealSearchList = MutableStateFlow<State<MealSearchState>>(State.loading())
    val mealSearchList: StateFlow<State<MealSearchState>> = _mealSearchList*/

    private val _meals: MutableStateFlow<State<List<Meal>>> = MutableStateFlow(State.doNothing())
    val meals: StateFlow<State<List<Meal>>> = _meals

    /*fun testLiveData() = liveData<Boolean> {
        emit(true)
        delay(2000)
        emit(false)
    }*/
    fun getSearchMeals(string: String)  = viewModelScope.launch {
        _meals.value = State.loading()
        searchMealsUseCase(string).map { resource -> State.fromResource(resource) }
            .collect{ state ->
                _meals.value = state
            }
    }
    /*fun getSearchMeals(string: String) {
        searchMealsUseCase(string).onStart {  }.catch {  }.onEach {
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
    }*/

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