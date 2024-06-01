package com.katran.myrecipes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.katran.myrecipes.data.Recipe
import com.katran.myrecipes.databinding.ItemRecipeBinding
import com.katran.myrecipes.ui.NavigationListener
import com.squareup.picasso.Picasso

class RecipesListAdapter(private val listener: NavigationListener) : RecyclerView.Adapter<RecipesListAdapter.RecipesListViewHolder>(){
    class RecipesListViewHolder(
        private var itemRecipeBinding: ItemRecipeBinding
    ) : ViewHolder(itemRecipeBinding.root) {
        fun bind(item: Recipe, listener: NavigationListener) {
            itemRecipeBinding.itemRecipeName.text = item.title
            if (item.image != "") {
                Picasso.get().load(item.image).into(itemRecipeBinding.itemRecipeImage)
            }
            itemRecipeBinding.itemRecipe.setOnClickListener {
                listener.openRecipe(item)
            }
        }
    }
    private var recipeList: List<Recipe> = listOf()
    private var binding: ItemRecipeBinding? = null

    fun setList(list: List<Recipe>?) {
        recipeList = list!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesListViewHolder {
        binding = ItemRecipeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RecipesListViewHolder(binding!!)
    }


    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: RecipesListViewHolder, position: Int) {
        holder.bind(recipeList[position], listener)

    }


}