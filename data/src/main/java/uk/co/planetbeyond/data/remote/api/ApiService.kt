package uk.co.planetbeyond.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import uk.co.planetbeyond.data.remote.dto.MealsDTO

interface ApiService {

    @GET("api/json/v1/1/search.php")
    suspend fun getSearchMealList(
        @Query("s") query: String
    ): MealsDTO


    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealDetails(
        @Query("i") i: String
    ): MealsDTO
}