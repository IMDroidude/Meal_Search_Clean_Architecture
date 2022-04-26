package uk.co.planetbeyond.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import uk.co.planetbeyond.data.repository.RepositoryImpl
import uk.co.planetbeyond.domain.api.Resource
import uk.co.planetbeyond.domain.model.MealDetails
import uk.co.planetbeyond.domain.model.toDomainMeal
import uk.co.planetbeyond.domain.model.toDomainMealDetails
import java.io.IOException
import javax.inject.Inject

class GetMealDetail @Inject constructor(private val repository: RepositoryImpl) {

    operator fun invoke(id: String): Flow<Resource<List<MealDetails>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getSearchMealDetail(id)?.map {
                it.toDomainMealDetails()
            }
            if(!data.isNullOrEmpty()){
                emit(Resource.Success(data))
            }
        } catch (e: Exception) {
            emit(Resource.Error(""))
        }
    }
}

