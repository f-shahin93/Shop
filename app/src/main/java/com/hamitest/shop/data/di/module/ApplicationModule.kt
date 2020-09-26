package com.hamitest.shop.data.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    @Named("BASE_URL")
    fun getUrlBase(): String {
        return "https://woocommerce.maktabsharif.ir/wp-json/wc/v3/"
    }

}