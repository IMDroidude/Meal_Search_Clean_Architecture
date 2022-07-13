package uk.co.planetbeyond.domain.repository

import kotlinx.coroutines.flow.Flow
import uk.co.planetbeyond.domain.api.Resource
import uk.co.planetbeyond.domain.model.Meal

interface Repository {

    suspend fun getSearchMealList(query: String): List<Meal>?

    fun searchMeals(query: String):Flow<Resource<List<Meal>>>
    ///suspend fun getSearchMealDetail(id: String): List<MealDetails>?
}