package com.katran.myrecipes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.katran.myrecipes.databinding.FragmentRecipeViewBinding
import com.katran.myrecipes.network.NetworkClient
import com.squareup.picasso.Picasso

class RecipeViewFragment : Fragment() {

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
        bind()
    }
    private fun bind() {
        val networkClient = NetworkClient()
        networkClient.getRecipesList(1) { recipesList ->
            val recipe = recipesList.recipes[0]
            Picasso.get().load(recipe.image).into(binding!!.recipeImage)
            binding?.recipeName?.text = recipe.title
            binding?.recipeId?.text = recipe.id.toString()

        }
    }
}
