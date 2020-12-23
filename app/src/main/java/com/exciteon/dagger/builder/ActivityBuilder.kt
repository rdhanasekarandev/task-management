package com.exciteon.dagger.builder

import com.exciteon.ui.auth.AuthActivity
import com.exciteon.ui.auth.AuthFragmentProvider
import com.exciteon.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module(includes = [AuthFragmentProvider::class])
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity() : SplashActivity

    @ContributesAndroidInjector
    abstract fun bindAuthActivity() : AuthActivity
}