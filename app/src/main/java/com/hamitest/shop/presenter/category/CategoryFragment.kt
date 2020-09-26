package com.hamitest.shop.presenter.category

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.hamitest.shop.MainActivity
import com.hamitest.shop.R
import com.hamitest.shop.data.di.module.ViewModelFactory
import com.hamitest.shop.databinding.FragmentCategoryBinding
import com.hamitest.shop.presenter.home.ParentCategoryItem
import javax.inject.Inject

class CategoryFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var categoryViewModel: CategoryViewModel
    private lateinit var mBinding: FragmentCategoryBinding
    private lateinit var mCategoriesList: List<ParentCategoryItem>
    private lateinit var mViewPagerAdapter: FragmentStateAdapter
    private var mCurrentPosition: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainActivitySubComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        categoryViewModel =
            ViewModelProvider(this, viewModelFactory).get(CategoryViewModel::class.java)

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false)

        categoryViewModel.getParentCategories().observe(viewLifecycleOwner, Observer {
            mCategoriesList = it
            initUi()
            setupTabLayout()
        })

        return mBinding.root
    }


    private fun initUi() {
        for (i in mCategoriesList) {
            mBinding.tabLayoutCategory.addTab(mBinding.tabLayoutCategory.newTab().setTag(i.name))
        }
    }

    private fun setupTabLayout() {
        mViewPagerAdapter = object : FragmentStateAdapter(childFragmentManager, lifecycle) {
            override fun getItemCount(): Int {
                return mCategoriesList.size
            }

            override fun createFragment(position: Int): Fragment {
                return SubCategoryFragment.newInstance(mCategoriesList[position].id)
            }
        }

        mBinding.categoryViewPager.adapter = mViewPagerAdapter
        TabLayoutMediator(
            mBinding.tabLayoutCategory,
            mBinding.categoryViewPager
        ) { tab, position -> tab.text = mCategoriesList[position].name }.attach()

    }


}