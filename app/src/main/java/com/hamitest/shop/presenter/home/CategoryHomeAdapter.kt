package com.hamitest.shop.presenter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hamitest.shop.R
import com.hamitest.shop.databinding.ItemListCategoryHomePageBinding


class CategoryHomeAdapter(val mList: List<ParentCategoryItem>) :
    RecyclerView.Adapter<CategoryHomeAdapter.HomeCategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        return HomeCategoryViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        holder.bindCategory(mList[position])
    }


    class HomeCategoryViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_category_home_page, parent, false)
    ) {

        private lateinit var mParentCategory: ParentCategoryItem
        private var mCategoryHpBinding: ItemListCategoryHomePageBinding =
            DataBindingUtil.bind(itemView)!!

        init {
            mCategoryHpBinding.root.setOnClickListener {
//                val intent: Intent = CategoryViewPagerActivity.newIntent(String.valueOf(mCategories.getId()))
//                mContext.startActivity(intent)
            }
        }

        fun bindCategory(parentCategoryItem: ParentCategoryItem) {
            mParentCategory = parentCategoryItem
            mCategoryHpBinding.tvCategoryHomePage.text = parentCategoryItem.name
        }

    }


}
