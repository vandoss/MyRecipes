package com.katran.myrecipes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.katran.myrecipes.data.Ingredient
import com.katran.myrecipes.databinding.ItemProductBinding

class ShoppingListAdapter : Adapter<ShoppingListAdapter.ShoppingListViewHolder>() {

    private var shoppingList: List<Ingredient> = listOf()
    private var binding: ItemProductBinding? = null

    fun setList(list: List<Ingredient>) {
        shoppingList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {

        binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ShoppingListViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return shoppingList.count()
    }

    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        holder.bind(shoppingList[position])
    }

    class ShoppingListViewHolder(
        private val itemBinding: ItemProductBinding
    ) : ViewHolder(itemBinding.root) {

        fun bind(item: Ingredient) {
            itemBinding.productCount.text = item.toString()
            itemBinding.productName.text = item.name
        }


    }
}