package uk.co.planetbeyond.data.repository

import uk.co.planetbeyond.data.remote.api.ApiService
import uk.co.planetbeyond.data.remote.dto.MealDTO
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
)  {

    suspend fun getSearchMealList(query: String): List<MealDTO>? {
        return apiService.getSearchMealList(query).meals
    }
}