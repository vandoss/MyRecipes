package com.katran.myrecipes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.katran.myrecipes.R
import com.katran.myrecipes.adapters.RecipesListAdapter
import com.katran.myrecipes.data.Ingredient
import com.katran.myrecipes.data.Recipe
import com.katran.myrecipes.databinding.FragmentRecipesListBinding
import com.katran.myrecipes.network.NetworkClient

class RecipesListFragment(private val listener: NavigationListener, val source: Int = FROM_NETWORK) : Fragment() {

    private var binding :FragmentRecipesListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipesListBinding.inflate(inflater, container,false)
        return binding?.root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (source) {
            FROM_NETWORK  -> initListFromNetwork()
            FROM_DATABASE -> initListFromDB()
        }


    }

    private fun initListFromNetwork() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this.requireContext())
        val apiKey = preferences.getString("apiKey", "null")
        val networkClient = NetworkClient(apiKey)
        networkClient.getRecipesList(10) {
            val recipesListAdapter = RecipesListAdapter(listener)
            binding?.recipesList?.adapter = recipesListAdapter
            recipesListAdapter.setList(it)
        }
        binding?.recipesListTitle?.text = getString(R.string.recipes_from_network)
        binding?.newRecipeButton?.visibility = View.GONE

    }

    private fun initListFromDB() {
        val recipesList = listOf(
            Recipe(1, title = "FirstRecipe", image = "", listOf<Ingredient>(), ""),
            Recipe(2, title = "SecondRecipe", image = "", listOf<Ingredient>(), ""),
            Recipe(3, title = "ThirdRecipe", image = "", listOf<Ingredient>(), ""))
        val recipesListAdapter = RecipesListAdapter(listener)
        binding?.recipesList?.adapter = recipesListAdapter
        recipesListAdapter.setList(recipesList)
    }
    companion object {
        const val FROM_NETWORK = 1
        const val FROM_DATABASE = 2
    }
}

