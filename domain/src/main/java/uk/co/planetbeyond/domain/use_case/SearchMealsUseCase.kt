package uk.co.planetbeyond.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uk.co.planetbeyond.domain.api.Resource
import uk.co.planetbeyond.domain.model.Meal
import uk.co.planetbeyond.domain.repository.Repository
import javax.inject.Inject

class SearchMealsUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(search: String): Flow<Resource<List<Meal>>> =
        repository.searchMeals(search)//.debounce(2000)

    /*operator fun invoke(search:String): Flow<Resource<List<Meal>>> = flow {
        emit(Resource.Loading())
        try {
            val data = repository.getSearchMealList(search)
            if(!data.isNullOrEmpty()){
                emit(Resource.Success(data))
            }
        } catch (e: Exception) {
            emit(Resource.Error(""))
        }
    }
*/
}