package uk.co.planetbeyond.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import uk.co.planetbeyond.data.remote.api.ApiService
import uk.co.planetbeyond.data.remote.dto.MealDTO
import uk.co.planetbeyond.data.remote.dto.toDomainMeal
import uk.co.planetbeyond.domain.api.Resource
import uk.co.planetbeyond.domain.api.State
import uk.co.planetbeyond.domain.model.Meal
import uk.co.planetbeyond.domain.model.MealDetails
import uk.co.planetbeyond.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    // FIXME: update below param with RemoteDataSource and LocalDataSource
    private val apiService: ApiService
    // FIXME: Also include Mapper classs to do mapping
)  :Repository{

    override suspend fun getSearchMealList(query: String): List<Meal>? {
        return apiService.getSearchMealList(query).meals?.map {
            it.toDomainMeal()
        }
    }

    override fun searchMeals(query: String): Flow<Resource<List<Meal>>> = safeApiCall {
        apiService.getSearchMealList(query).meals?.map { it.toDomainMeal() }
    } /*flow {
        val meals = apiService.getSearchMealList(query).meals?.map {
            it.toDomainMeal()
        }
        meals?.let { emit(Resource.Success(it)) }
    }*/

    /*override suspend fun getSearchMealDetail(id: String): List<MealDetails>? {
        return apiService.getMealDetails(id).meals.map {

        }
    }*/
    /*suspend fun getSearchMealDetail(id: String): List<MealDTO>? {
        return apiService.getMealDetails(id).meals.map {
            it.toDomainMeal()
        }
    }*/

    inline fun <T> safeApiCall(
        crossinline body: suspend () -> T?
    ): Flow<Resource<T>> {
        return flow {
            try {
                // blocking block
                val users = withContext(Dispatchers.IO) {
                    body()
                }
                users?.let { emit(Resource.Success(users)) }?:apply {
                    emit(Resource.Failed("No data found"))
                }

            } catch (e: Exception) {
                emit(Resource.Failed(e.message?:e.localizedMessage))
            }
        }
    }

}