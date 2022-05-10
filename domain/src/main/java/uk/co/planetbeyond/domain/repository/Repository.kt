package uk.co.planetbeyond.domain.repository

import uk.co.planetbeyond.domain.model.Meal
import uk.co.planetbeyond.domain.model.MealDetails

interface Repository {

    suspend fun getSearchMealList(query: String): List<Meal>?
    ///suspend fun getSearchMealDetail(id: String): List<MealDetails>?
}