package com.hamitest.shop.data.di.module

import androidx.lifecycle.ViewModel
import com.hamitest.shop.presenter.allproductlist.AllProductListViewModel
import com.hamitest.shop.presenter.category.CategoryViewModel
import com.hamitest.shop.presenter.detailproduct.DetailProductViewModel
import com.hamitest.shop.presenter.home.HomeViewModel
import com.hamitest.shop.presenter.profile.ProfileViewModel
import com.hamitest.shop.presenter.shoppingcart.ShoppingCartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailProductViewModel::class)
    internal abstract fun detailViewModel(viewModel: DetailProductViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    internal abstract fun categoryViewModel(viewModel: CategoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AllProductListViewModel::class)
    internal abstract fun allProductListViewModel(viewModel: AllProductListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    internal abstract fun profileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShoppingCartViewModel::class)
    internal abstract fun shoppingCartViewModel(viewModel: ShoppingCartViewModel): ViewModel

}