package com.katran.myrecipes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.katran.myrecipes.R
import com.katran.myrecipes.data.Product
import com.katran.myrecipes.databinding.ItemProductBinding

class ShoppingListAdapter : Adapter<ShoppingListAdapter.ShoppingListViewHolder>() {

    private var shoppingList: List<Product> = listOf()
    var binding: ItemProductBinding? = null

    fun setList(list: List<Product>) {
        shoppingList = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {

        binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
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

        fun bind(item: Product) {
            itemBinding.productCount.text = item.countToString()
            itemBinding.productName.text = item.name
        }


    }
}