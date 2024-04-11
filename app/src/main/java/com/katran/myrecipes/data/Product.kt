package com.katran.myrecipes.data

data class Product(
    val name: String,
    val count: Float,
    val dimension: String
) {
    fun countToString() : String {
        return "$count $dimension"
    }
}