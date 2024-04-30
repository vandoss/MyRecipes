package com.katran.myrecipes.network


import com.katran.myrecipes.data.RecipesList
import retrofit2.Call
import retrofit2.http.GET

interface RandomRecipe {
    @GET("random?number=1&apiKey=15a1223ba17e4e168f17c45cad0db0ab")
    fun getRandomRecipe(): Call<RecipesList>
}

interface RandomRecipesList {

    @GET ("random?number=30&apiKey=15a1223ba17e4e168f17c45cad0db0ab")
    fun getRecipesList(): Call<RecipesList>
}