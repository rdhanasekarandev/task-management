package com.exciteon.dagger.component

import android.app.Application
import com.exciteon.App
import com.exciteon.dagger.builder.ActivityBuilder
import com.exciteon.dagger.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class, AppModule::class])
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}