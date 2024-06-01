package com.katran.myrecipes.ui


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.preference.PreferenceManager
import com.katran.myrecipes.R
import com.katran.myrecipes.data.Recipe
import com.katran.myrecipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val apiKey = preferences.getString("apiKey", "")
        if (apiKey == "") {
            notifyAboutPreferences()
        }
        else {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_container, RecipesListFragment(this@MainActivity))
            }
        }

        binding.networkButton.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_container, RecipesListFragment(this@MainActivity))
            }
        }

        binding.listButton.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(
                    R.id.main_container, RecipesListFragment(
                    this@MainActivity, RecipesListFragment.FROM_DATABASE
                    )
                )
            }

        }
        binding.favoritesButton.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.main_container, RecipeViewFragment())
            }
        }

        binding.shoppingListButton.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.main_container, ShoppingListFragment())
            }
        }
        binding.settingsButton.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.main_container, MySettingsFragment())
            }
        }
    }

    override fun openRecipe(recipe: Recipe) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.main_container, RecipeViewFragment(recipe))
            addToBackStack("")
        }
    }

    private fun notifyAboutPreferences() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        builder
            .setTitle(getString(R.string.settings_alert_title))
            .setMessage(getString(R.string.setting_alert_text))
            .setPositiveButton(getString(R.string.ok)) { _, _ ->
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.main_container, MySettingsFragment())
                }
            }
            .setNeutralButton("I don't have one") { _,_ ->
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("https://spoonacular.com/food-api"))
                startActivity(intent)
            }
        builder.create().show()
    }
}