package uk.co.planetbeyond.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.planetbeyond.data.remote.api.ApiService
import uk.co.planetbeyond.data.repository.RepositoryImpl

/*
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    fun providesRepository(apiService: ApiService): RepositoryImpl = RepositoryImpl(apiService)
}*/
