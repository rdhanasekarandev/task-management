package com.exciteon.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.exciteon.BR
import com.exciteon.R
import com.exciteon.databinding.ActivitySplashBinding
import com.exciteon.ui.auth.AuthActivity
import com.exciteon.ui.base.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(),SplashNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_splash
    override val viewModel: SplashViewModel
        get() = ViewModelProvider(this,viewModelFactory).get(SplashViewModel::class.java)
    private lateinit var mBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mBinding = viewDataBinding!!
        Handler().postDelayed({
            viewModel.defaultSettingsInCache()
        },2000)
    }

    override fun openLoginActivity() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    override fun openHomeActivity() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }
}