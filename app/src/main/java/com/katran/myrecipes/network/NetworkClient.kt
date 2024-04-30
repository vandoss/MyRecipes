package com.katran.myrecipes.network

import android.util.Log
import com.katran.myrecipes.data.Recipe
import com.katran.myrecipes.data.RecipesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.spoonacular.com/recipes/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var recipeId: Int? = null
    var recipeTitle: String? = null
    var recipeImage: String?= null
    val randomRecipe: RandomRecipe = retrofit.create(RandomRecipe::class.java)

    fun getRandomRecipe(callback: (Int?, String?, String?) -> Unit) {

        randomRecipe.getRandomRecipe().enqueue(object: Callback<RecipesList> {
            override fun onResponse(call: Call<RecipesList>, response: Response<RecipesList>) {
                val randomRecipesList: List<Recipe> = response.body()!!.recipes
                recipeId = randomRecipesList[0].id
                recipeTitle = randomRecipesList[0].title
                recipeImage = randomRecipesList[0].image
                Log.i("My Debug","Response Body is $response")
                Log.i("My Debug", "Got recipe id = $recipeId, recipeTitle = $recipeTitle, recipeImage = $recipeImage")
                callback.invoke(recipeId,recipeTitle,recipeImage)
            }

            override fun onFailure(call: Call<RecipesList>, error: Throwable) {
                Log.e("Recipe APP DEBUG", "It's an API error", error)
            }
        })
    }


}