package com.hamitest.shop.presenter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hamitest.shop.R
import com.hamitest.shop.databinding.ItemListSubcategoriesBinding
import com.squareup.picasso.Picasso


class SubCategoryAdapter(
    val list: List<SubCategoryItem>,
    var createFragmentCallBackSubToAllProList: CreateFragmentCallBackSubToAllProList
) :
    RecyclerView.Adapter<SubCategoryAdapter.SubCategoriesViewHolderFragment>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubCategoriesViewHolderFragment {
        return SubCategoriesViewHolderFragment(parent, createFragmentCallBackSubToAllProList)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SubCategoriesViewHolderFragment, position: Int) {
        holder.bindSubCategories(list[position])
    }


    class SubCategoriesViewHolderFragment(
        parent: ViewGroup,
        createFragmentCallBackSubToAllProList: CreateFragmentCallBackSubToAllProList
    ) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_subcategories, parent, false)
        ) {

        private lateinit var subCategory: SubCategoryItem
        private var subcategoriesBinding: ItemListSubcategoriesBinding =
            DataBindingUtil.bind(itemView)!!
        private var context = parent.context

        fun bindSubCategories(subCategory: SubCategoryItem) {
            this.subCategory = subCategory
            subcategoriesBinding.tvSubCategoriesFragViewp.text = subCategory.name
            Picasso.with(context)
                .load(subCategory.categoryImage.src)
                .into(subcategoriesBinding.ivSubCategoriesFragViewp)
        }

        init {
            itemView.setOnClickListener {
                val queryMap =
                    hashMapOf("category" to subCategory.id.toString(), "name" to subCategory.name)

                createFragmentCallBackSubToAllProList.navigateFragment(queryMap)
            }
        }
    }


    interface CreateFragmentCallBackSubToAllProList {
        fun navigateFragment(queryMap: HashMap<String, String>)
    }

}