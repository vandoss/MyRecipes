package com.katran.myrecipes.data

data class Recipe(
    val name : String,
    val category : RecipeCategory) {

    var productList : List<Product> = listOf()
    var imagePath : String = ""
}

enum class RecipeCategory(val catecoryText: String) {
    NONE("No Category"),
    SOUP("Soups"),
    MAIN("Main Dishes"),
    DESERT("Deserts"),
    DRINK("Drinks")
}