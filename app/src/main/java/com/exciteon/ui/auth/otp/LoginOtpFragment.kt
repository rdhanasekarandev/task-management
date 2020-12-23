package com.exciteon.ui.auth.otp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.exciteon.BR
import com.exciteon.R
import com.exciteon.databinding.FragmentLoginOtpBinding
import com.exciteon.ui.auth.AuthViewModel
import com.exciteon.ui.base.BaseFragment
import com.exciteon.utils.AuthUiEvent
import com.exciteon.utils.RxBus
import com.exciteon.utils.onClick
import javax.inject.Inject

class LoginOtpFragment : BaseFragment<FragmentLoginOtpBinding, LoginOtpViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_login_otp
    override val viewModel: LoginOtpViewModel
        get() = ViewModelProvider(this,viewModelFactory).get(LoginOtpViewModel::class.java)
    private lateinit var mBinding: FragmentLoginOtpBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = viewDataBinding!!
        initView()
        subscribeToLiveData()
    }

    private fun subscribeToLiveData(){
        viewModel.response.observe(requireActivity(), {
            if (it == "success") {
                RxBus.publish(AuthUiEvent.Navigate(AuthViewModel.Screen.OTP_HOME))
            }
        })
    }

    private fun initView(){
        mBinding.authVerify.onClick {
            Log.d("otp",mBinding.otpView.otp!!+" "+viewModel.codeSent)
            hideKeyboard()
            mBinding.authVerify.visibility = View.GONE
            mBinding.progressBar.visibility = View.VISIBLE
            viewModel.otp.set(mBinding.otpView.otp!!)
            when {
                mBinding.otpView.otp.isNullOrEmpty() -> {
                    showSnackBar(getString(R.string.error),getString(R.string.invalid_otp),"")
                }
                mBinding.otpView.otp!!.length!=6 -> {
                    showSnackBar(getString(R.string.error),getString(R.string.invalid_otp),"")
                }
                else -> {
                    viewModel.verifySignInCode(requireActivity())
                }
            }
        }
    }

}