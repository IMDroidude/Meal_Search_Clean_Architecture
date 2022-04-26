package uk.co.planetbeyond.domain.model

import uk.co.planetbeyond.data.remote.dto.MealDTO

data class Meal(
    val id: String,
    val name: String,
    val image: String
){


}

fun MealDTO.toDomainMeal(): Meal {
    return Meal(
        id = this.idMeal,
        name = this.strMeal ?: "",
        image = this.strMealThumb ?: ""
    )
}