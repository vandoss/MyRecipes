package com.katran.myrecipes.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.katran.myrecipes.R
import com.katran.myrecipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.randomRecipeButton.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_activity, RecipeViewFragment())
                addToBackStack("")
            }
        }

        binding.recipesListButton.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_activity, RecipesListFragment())
                addToBackStack("")
            }
        }

        binding.shoppingListButton.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_activity, ShoppingListFragment())
                addToBackStack("")
            }
        }
    }
}