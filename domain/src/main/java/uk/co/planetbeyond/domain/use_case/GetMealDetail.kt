package uk.co.planetbeyond.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uk.co.planetbeyond.domain.api.Resource
import uk.co.planetbeyond.domain.model.MealDetails
import uk.co.planetbeyond.domain.repository.Repository
import javax.inject.Inject

class GetMealDetail @Inject constructor(private val repository: Repository) {

    operator fun invoke(id: String): Flow<Resource<List<MealDetails>>> = flow {
        try {
            emit(Resource.Loading())
            /*val data = repository.getSearchMealDetail(id)
            if(!data.isNullOrEmpty()){
                emit(Resource.Success(data))
            }*/
        } catch (e: Exception) {
            emit(Resource.Error(""))
        }
    }
}

