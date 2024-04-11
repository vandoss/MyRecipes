package com.katran.myrecipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.katran.myrecipes.adapters.ShoppingListAdapter
import com.katran.myrecipes.data.Product
import com.katran.myrecipes.databinding.FragmentShoppingListBinding

class ShoppingListFragment : Fragment() {

    private var binding: FragmentShoppingListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingListBinding.inflate(inflater, container, false)
        return binding?.root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shoppingList = listOf<Product>(
            Product("Potato", 3f, "kilo"),
            Product("Egg", 10f, "piece"),
            Product("Tomato", 1.5f, "kilo"),
            Product("Chicken", 1f, "piece")
        )

        val shoppingListAdapter: ShoppingListAdapter = ShoppingListAdapter()
        binding?.shoppingList?.adapter = shoppingListAdapter
        shoppingListAdapter.setList(shoppingList)
    }
}

