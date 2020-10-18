package com.hamitest.shop.presenter.allproductlist

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hamitest.shop.R
import com.hamitest.shop.databinding.ItemListAllProductBinding
import com.squareup.picasso.Picasso

class AllProductListAdapter(var list: List<AllProductListItem>) :
    RecyclerView.Adapter<AllProductListAdapter.AllProductListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllProductListViewHolder {
        return AllProductListViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AllProductListViewHolder, position: Int) {
        holder.bind(list[position])
    }


    class AllProductListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_all_product, parent, false)
    ) {

        var context: Context = parent.context
        private var binding: ItemListAllProductBinding = DataBindingUtil.bind(itemView)!!

        fun bind(allProductListItem: AllProductListItem) {
            if (allProductListItem.images.isNotEmpty()) {
                Picasso.with(context)
                    .load(allProductListItem.images[0].src)
                    .placeholder(R.drawable.place_holder_shopping_cart)
                    .into(binding.IvAllProductList)
            }

            binding.tvNameProductCategoryViewPager.text = allProductListItem.name

            if (allProductListItem.regularPrice.equals("")) {
                binding.tvPriceRegularItemListCategoryViewPager.visibility = View.INVISIBLE
                binding.tvPriceProductCategoryViewPager.text = allProductListItem.price + "تومان "
            } else {
                binding.tvPriceRegularItemListCategoryViewPager.setVisibility(View.VISIBLE);
                binding.tvPriceProductCategoryViewPager.text = allProductListItem.price + " تومان";
                binding.tvPriceRegularItemListCategoryViewPager.text =
                    allProductListItem.regularPrice + " تومان";
                binding.tvPriceRegularItemListCategoryViewPager.paintFlags =
                    Paint.STRIKE_THRU_TEXT_FLAG;
            }

        }


    }


}