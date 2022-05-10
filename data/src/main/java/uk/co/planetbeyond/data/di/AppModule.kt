package uk.co.planetbeyond.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.planetbeyond.data.remote.api.ApiService
import uk.co.planetbeyond.data.repository.RepositoryImpl
import uk.co.planetbeyond.domain.repository.Repository
import uk.co.planetbeyond.domain.use_case.GetMealDetail
import uk.co.planetbeyond.domain.use_case.SearchMealsUseCase

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMealSearch(repository:Repository): SearchMealsUseCase {
        return SearchMealsUseCase(repository)
    }

    @Provides
    fun provideMealDetails(repository:Repository): GetMealDetail {
        return GetMealDetail(repository)
    }


   /* @Provides
    fun provideRepositoryImpl(mealSearchAPI: ApiService): RepositoryImpl {
        return RepositoryImpl(mealSearchAPI)
    }*/

}