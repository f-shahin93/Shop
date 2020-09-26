package com.hamitest.shop.data.di.component

import android.app.Application
import com.hamitest.shop.data.di.module.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules =
    [NetworkModule::class,
        ApplicationModule::class,
        SubComponentModule::class,
        ViewModelModule::class]
)

interface ApplicationComponent {

    fun mainActivitySubComponent(): MainActivitySubComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }


}