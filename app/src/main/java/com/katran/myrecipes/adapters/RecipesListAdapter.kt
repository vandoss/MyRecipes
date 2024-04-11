package com.katran.myrecipes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.katran.myrecipes.R
import com.katran.myrecipes.data.Product
import com.katran.myrecipes.data.Recipe
import com.katran.myrecipes.databinding.ItemProductBinding
import com.katran.myrecipes.databinding.ItemRecipeBinding

class RecipesListAdapter : RecyclerView.Adapter<RecipesListAdapter.RecipesListViewHolder>(){
    class RecipesListViewHolder(
        private var itemRecipeBinding: ItemRecipeBinding
    ) : ViewHolder(itemRecipeBinding.root) {
        fun bind(item: Recipe) {
            itemRecipeBinding.recipeName.text = item.name

        }
    }


    private var recipeList: List<Recipe> = listOf()
    var binding: ItemRecipeBinding? = null

    fun setList(list: List<Recipe>) {
        recipeList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesListViewHolder {
        binding = ItemRecipeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipesListAdapter.RecipesListViewHolder(binding!!)
    }


    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: RecipesListViewHolder, position: Int) {
        holder.bind(recipeList[position])
    }


}