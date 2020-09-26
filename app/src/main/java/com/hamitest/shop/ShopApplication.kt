package com.hamitest.shop

import android.app.Application
import com.hamitest.shop.data.di.component.ApplicationComponent
import com.hamitest.shop.data.di.component.DaggerApplicationComponent

class ShopApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder().application(this)
            .build()

    }

}