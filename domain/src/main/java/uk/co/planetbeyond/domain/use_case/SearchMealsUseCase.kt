package uk.co.planetbeyond.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uk.co.planetbeyond.domain.api.Resource
import uk.co.planetbeyond.domain.model.Meal
import uk.co.planetbeyond.domain.repository.Repository
import javax.inject.Inject

class SearchMealsUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(search:String): Flow<Resource<List<Meal>>> = flow {
        emit(Resource.Loading())
        try {
            val data = repository.getSearchMealList(search)
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(""))
        }
    }
}