package com.hamitest.shop

import android.app.Application
import com.hamitest.shop.data.di.component.ApplicationComponent
import com.hamitest.shop.data.di.component.DaggerApplicationComponent
import io.realm.Realm
import io.realm.RealmConfiguration

class ShopApplication : Application() {

    companion object {
        lateinit var instance: ShopApplication
    }

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        instance = this
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder().application(this)
            .build()

        initRealmDB()

    }

    private fun initRealmDB() {
        Realm.init(applicationContext)
        val config = RealmConfiguration.Builder()
            .name("Shop.db")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)
    }

}