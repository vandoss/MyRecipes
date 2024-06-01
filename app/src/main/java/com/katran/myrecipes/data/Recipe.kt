package com.katran.myrecipes.data

data class Recipe(
    val id: Int,
    val title: String,
    val image: String,
    val extendedIngredients: List<Ingredient>,
    val instructions: String) {
}