package com.hamitest.shop.presenter.shoppingcart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hamitest.shop.R

class ShoppingCartAdapter(var list: List<CartProductItem>) :RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        return ShoppingCartViewHolder(parent)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        TODO("Not yet implemented")
    }




    class ShoppingCartViewHolder(parent : ViewGroup)
        : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_shopping_cart ,parent,false)){




    }



}