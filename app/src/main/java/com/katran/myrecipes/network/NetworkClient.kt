package com.katran.myrecipes.network

import android.util.Log
import com.katran.myrecipes.data.RecipesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {
    private val apiKey = "15a1223ba17e4e168f17c45cad0db0ab"
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.spoonacular.com/recipes/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val randomRecipes: RandomRecipes = retrofit.create(RandomRecipes::class.java)

    fun getRecipesList(number: Int, callback: (RecipesList) -> Unit) {

        randomRecipes.getRandomRecipesList(number, apiKey).enqueue(object: Callback<RecipesList> {
            override fun onResponse(call: Call<RecipesList>, response: Response<RecipesList>) {
                val randomRecipesList = RecipesList(response.body()!!.recipes)
                callback.invoke(randomRecipesList)
            }

            override fun onFailure(call: Call<RecipesList>, error: Throwable) {
                Log.e("Recipe APP DEBUG", "It's an API error", error)
            }
        })
    }


}