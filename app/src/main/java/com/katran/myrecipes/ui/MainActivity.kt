package com.katran.myrecipes.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.katran.myrecipes.R
import com.katran.myrecipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
         //   add<ShoppingListFragment>(R.id.main_activity)
            add<MainFragment>(R.id.main_activity)
            addToBackStack("")
        }
    }
}