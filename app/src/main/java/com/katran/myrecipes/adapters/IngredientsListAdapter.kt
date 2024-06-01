package com.katran.myrecipes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.katran.myrecipes.adapters.IngredientsListAdapter.IngredientViewHolder
import com.katran.myrecipes.data.Ingredient
import com.katran.myrecipes.databinding.ItemIngredientBinding

class IngredientsListAdapter : Adapter<IngredientViewHolder>() {

    private var ingredientList: List<Ingredient> = listOf()
    private var binding: ItemIngredientBinding? = null

    fun setList(list: List<Ingredient>) {
        ingredientList = list
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        binding = ItemIngredientBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return IngredientViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(ingredientList[position])
    }

    class IngredientViewHolder(
        private var itemIngredientBinding: ItemIngredientBinding
    ) : RecyclerView.ViewHolder(itemIngredientBinding.root) {
        fun bind(item: Ingredient) {
            itemIngredientBinding.ingredientName.text = item.name
            itemIngredientBinding.ingredientCount.text = item.toString()
        }
    }
}