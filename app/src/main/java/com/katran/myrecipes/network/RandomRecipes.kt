package com.katran.myrecipes.network


import com.katran.myrecipes.data.RecipesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomRecipes {
    @GET("random")
    fun getRandomRecipesList(@Query ("number")  number: Int, @Query ("apiKey") apiKey: String): Call<RecipesList>
}

