package com.katran.myrecipes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.katran.myrecipes.R
import com.katran.myrecipes.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    private var binding: FragmentMainBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root ?: super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.randomRecipeButton?.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_fragment, RecipeViewFragment())
                addToBackStack("")
            }
        }

        binding?.recipesListButton?.setOnClickListener {
            childFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_fragment, RecipesListFragment())
                addToBackStack("")
            }
        }

        binding?.shoppingListButton?.setOnClickListener {
            childFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_fragment, ShoppingListFragment())
                addToBackStack("")
            }
        }
    }
}