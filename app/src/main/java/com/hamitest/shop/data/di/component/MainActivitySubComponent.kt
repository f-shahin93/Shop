package com.hamitest.shop.data.di.component

import com.hamitest.shop.MainActivity
import com.hamitest.shop.presenter.allproductlist.AllProductListFragment
import com.hamitest.shop.presenter.category.CategoryFragment
import com.hamitest.shop.presenter.category.SubCategoryFragment
import com.hamitest.shop.presenter.detailproduct.DetailProductFragment
import com.hamitest.shop.presenter.home.HomeFragment
import com.hamitest.shop.presenter.profile.ProfileFragment
import com.hamitest.shop.presenter.shoppingcart.ShoppingCartFragment
import dagger.Subcomponent

@Subcomponent
interface MainActivitySubComponent {

    fun inject(homeFragment: HomeFragment)
    fun inject(detailFragment: DetailProductFragment)
    fun inject(allProductListFragment: AllProductListFragment)
    fun inject(categoryFragment: CategoryFragment)
    fun inject(subCategoryFragment: SubCategoryFragment)
    fun inject(profileFragment: ProfileFragment)
    fun inject(shoppingCartFragment: ShoppingCartFragment)
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivitySubComponent
    }
}