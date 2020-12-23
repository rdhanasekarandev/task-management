package com.exciteon.ui.auth

import com.exciteon.ui.auth.cookie.NameFragment
import com.exciteon.ui.auth.create.CreateFragment
import com.exciteon.ui.auth.login.LoginFragment
import com.exciteon.ui.auth.otp.CreateOtpFragment
import com.exciteon.ui.auth.otp.LoginOtpFragment
import com.exciteon.ui.auth.password.CreatePasswordFragment
import com.exciteon.ui.auth.password.LoginPasswordFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class AuthFragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideLoginFragmentFactory(): LoginFragment

    @ContributesAndroidInjector
    abstract fun provideLoginPasswordFragmentFactory(): LoginPasswordFragment

    @ContributesAndroidInjector
    abstract fun provideLoginOtpFragmentFactory(): LoginOtpFragment

    @ContributesAndroidInjector
    abstract fun provideCreateFragmentFactory(): CreateFragment

    @ContributesAndroidInjector
    abstract fun provideCreateOtpFactory(): CreateOtpFragment

    @ContributesAndroidInjector
    abstract fun provideCreatePasswordFragmentFactory(): CreatePasswordFragment

    @ContributesAndroidInjector
    abstract fun provideNameFragmentFactory(): NameFragment
}