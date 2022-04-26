package uk.co.planetbeyond.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.planetbeyond.data.remote.api.ApiService
import uk.co.planetbeyond.data.repository.RepositoryImpl
import uk.co.planetbeyond.domain.use_case.SearchMealsUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideMealSearchRepository(repositoryImpl: RepositoryImpl): SearchMealsUseCase {
        return SearchMealsUseCase(repositoryImpl)
    }

    @Provides
    fun provideRepositoryImpl(mealSearchAPI: ApiService): RepositoryImpl {
        return RepositoryImpl(mealSearchAPI)
    }

}