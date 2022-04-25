package uk.co.planetbeyond.data.repository

import uk.co.planetbeyond.data.remote.api.ApiService
import uk.co.planetbeyond.data.remote.dto.toDomainMeal
import uk.co.planetbeyond.data.remote.dto.toDomainMealDetails
import uk.co.planetbeyond.domain.model.Meal
import uk.co.planetbeyond.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {

    override suspend fun getSearchMealList(query: String): List<Meal> {
        return apiService.getSearchMealList(query).meals?.map {
            it.toDomainMeal()
        } ?: emptyList()
    }
}