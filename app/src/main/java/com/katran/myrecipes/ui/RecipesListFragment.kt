package com.katran.myrecipes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.katran.myrecipes.adapters.RecipesListAdapter
import com.katran.myrecipes.data.Recipe
import com.katran.myrecipes.databinding.FragmentRecipesListBinding

class RecipesListFragment : Fragment() {

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

        val recipesListAdapter: RecipesListAdapter = RecipesListAdapter()
        binding?.recipesList?.adapter = recipesListAdapter
        recipesListAdapter.setList(recipesList)
    }
}

