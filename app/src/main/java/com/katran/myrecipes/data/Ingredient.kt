package com.katran.myrecipes.data

data class Ingredient(
    val name: String,
    val amount: Float,
    val unit: String
) {
    override fun toString() : String {
        return "$amount $unit"
    }
}