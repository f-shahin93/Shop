package com.hamitest.shop.presenter.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hamitest.shop.R
import com.hamitest.shop.databinding.ItemListCardViewHomePBinding
import com.squareup.picasso.Picasso

class ProductHpAdapter(
    var mList: List<ProductItem>,
    var createFragmentCallBackHomeToDetail: CreateFragmentCallBackHomeToDetail
) :
    RecyclerView.Adapter<ProductHpAdapter.ProductViewHolder>() {

    private lateinit var mHomeViewModel: HomeViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding: ItemListCardViewHomePBinding = DataBindingUtil
            .inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_list_card_view_home_p,
                parent,
                false
            )

        return ProductViewHolder(binding, parent.context, createFragmentCallBackHomeToDetail)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class ProductViewHolder(
        binding: ItemListCardViewHomePBinding,
        context: Context,
        createFragmentCallBackHomeToDetail: CreateFragmentCallBackHomeToDetail
    ) :
        RecyclerView.ViewHolder(binding.getRoot()) {
        private val mBinding: ItemListCardViewHomePBinding
        private lateinit var mProductVh: ProductItem
        private var mContext = context

        fun bind(product: ProductItem) {
            mProductVh = product
            if (mProductVh.images.size > 0)
                Picasso.with(mContext)
                    .load(mProductVh.images.get(0).src)
                    .placeholder(R.drawable.place_holder_shopping_cart)
                    .into(mBinding.IvProductCardVHomePage)
            mBinding.tvNameProductCardVHomePage.text = mProductVh.name
            mBinding.tvPriceProductCardVHomePage.text = mProductVh.price
        }

        init {
            mBinding = binding
            mBinding.root.setOnClickListener {
                createFragmentCallBackHomeToDetail.navigateFragment(mProductVh.id)
            }
        }
    }

    interface CreateFragmentCallBackHomeToDetail {
        fun navigateFragment(productId: Int)
    }

}