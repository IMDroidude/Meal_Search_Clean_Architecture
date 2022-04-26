package uk.co.planetbeyond.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.planetbeyond.data.remote.api.ApiService
import uk.co.planetbeyond.data.repository.RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideMealSearchAPI(): ApiService {
        return Retrofit.Builder().baseUrl("https://www.themealdb.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }


    @Provides
    fun provideMealSearchRepository(mealSearchAPI: ApiService): RepositoryImpl {
        return RepositoryImpl(mealSearchAPI)
    }


    /*@Provides
    fun provideMealDetails(searchMealSearchAPI: MealSearchAPI): MealDetailsRepository {
        return MealDetailsRepositoryImpl(searchMealSearchAPI)
    }*/

}