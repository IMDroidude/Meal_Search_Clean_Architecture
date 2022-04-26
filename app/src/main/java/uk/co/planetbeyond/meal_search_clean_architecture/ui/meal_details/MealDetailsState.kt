package uk.co.planetbeyond.meal_search_clean_architecture.ui.meal_details

import uk.co.planetbeyond.domain.model.MealDetails

data class MealDetailsState(
    val isLoading: Boolean = false,
    val data: MealDetails? = null,
    val error: String = ""
) {
}