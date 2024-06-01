package com.katran.myrecipes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.katran.myrecipes.adapters.ShoppingListAdapter
import com.katran.myrecipes.data.Ingredient
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

        val shoppingList = listOf(
            Ingredient("Potato", 3f, "kilo"),
            Ingredient("Egg", 10f, "piece"),
            Ingredient("Tomato", 1.5f, "kilo"),
            Ingredient("Chicken", 1f, "piece")
        )

        val shoppingListAdapter = ShoppingListAdapter()
        binding?.shoppingList?.adapter = shoppingListAdapter
        shoppingListAdapter.setList(shoppingList)
    }
}

