package com.katran.myrecipes.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.katran.myrecipes.adapters.IngredientsListAdapter
import com.katran.myrecipes.data.Recipe
import com.katran.myrecipes.databinding.FragmentRecipeViewBinding
import com.katran.myrecipes.network.NetworkClient
import com.squareup.picasso.Picasso

class RecipeViewFragment(private var recipe: Recipe? = null) : Fragment() {

    private var binding: FragmentRecipeViewBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeViewBinding.inflate(inflater, container, false)
        return binding?.root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (this.recipe == null) {
            getNewRecipe {
                bind(it)
            }
        } else {
            bind(this.recipe!!)
        }
    }

    private fun getNewRecipe(callback: (Recipe) -> Unit) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this.requireContext())
        val networkClient = NetworkClient(preferences.getString("apiKey",""))

        networkClient.getRecipesList(1) { recipesList ->
            if (recipesList?.size != 0) {
                this.recipe = recipesList!![0]
            }
            callback.invoke(this.recipe!!)
        }
    }

    private fun bind(recipe: Recipe) {
        Picasso.get().load(recipe.image).into(binding!!.recipeImage)
        binding?.recipeName?.text = recipe.title
        binding?.recipeId?.text = recipe.id.toString()
        binding?.instructions?.text = recipe.instructions
        binding?.instructions?.movementMethod = ScrollingMovementMethod()
        val ingredientsListAdapter = IngredientsListAdapter()
        binding?.ingredientsList?.adapter = ingredientsListAdapter
        ingredientsListAdapter.setList(recipe.extendedIngredients)
    }
}
