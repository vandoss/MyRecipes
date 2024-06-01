package com.katran.myrecipes.ui

import com.katran.myrecipes.data.Recipe

interface NavigationListener {

    fun openRecipe(recipe: Recipe)
}