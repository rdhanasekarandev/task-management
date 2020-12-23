package com.exciteon.ui.auth.create

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.exciteon.BR
import com.exciteon.R
import com.exciteon.databinding.FragmentCreateBinding
import com.exciteon.ui.auth.AuthViewModel
import com.exciteon.ui.base.BaseFragment
import com.exciteon.utils.AuthUiEvent
import com.exciteon.utils.RxBus
import com.exciteon.utils.onClick
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CreateFragment : BaseFragment<FragmentCreateBinding, CreateViewModel>() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_create
    override val viewModel: CreateViewModel
        get() = ViewModelProvider(this,mViewModelFactory).get(CreateViewModel::class.java)
    private lateinit var mBinding: FragmentCreateBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = viewDataBinding!!
        initView()
        subscribeToLiveData()
    }

    private fun subscribeToLiveData(){
        viewModel.response.observe(requireActivity(),{
            if(it == "ok"){
                RxBus.publish(AuthUiEvent.Navigate(AuthViewModel.Screen.SIGN_UP_OTP_SCREEN,viewModel.emailOrPhoneNo.get()!!.trim(),viewModel.codeSent.get()!!.trim()))
            }else if(it == "fail"){
                mBinding.authNext.visibility = View.VISIBLE
                mBinding.progressbar.visibility = View.GONE
                showSnackBar(getString(R.string.invalid),getString(R.string.Phone_number_is_not_valid),"")
            }
        })
    }

    private fun initView(){
        mBinding.tvLogin.onClick { RxBus.publish(AuthUiEvent.Navigate(AuthViewModel.Screen.LOGIN_SCREEN,"Create")) }
        mBinding.authNext.onClick {
            hideKeyboard()
            when {
                viewModel.isEmailOrPhoneNo()==0 -> {
                    mBinding.authNext.visibility = View.GONE
                    mBinding.progressbar.visibility = View.VISIBLE
                    phoneVerification()
                }
                viewModel.isEmailOrPhoneNo()==1 -> {
                    showSnackBar(getString(R.string.invalid),getString(R.string.Phone_number_is_not_valid),"")
                }
                viewModel.isEmailOrPhoneNo()==2 -> {
                    RxBus.publish(AuthUiEvent.Navigate(AuthViewModel.Screen.SIGN_UP_PASSWORD_SCREEN,viewModel.emailOrPhoneNo.get()!!.trim()))
                }
                viewModel.isEmailOrPhoneNo()==3 -> {
                    showSnackBar(getString(R.string.invalid),getString(R.string.the_email_id_is_invalid),"")
                }
            }
        }
        mBinding.googleSignIn.onClick {
            mBinding.googleSignIn.visibility = View.GONE
            mBinding.googleProgressBar.visibility = View.VISIBLE
            RxBus.publish(AuthUiEvent.Navigate(AuthViewModel.Screen.GOOGLE_SIGN_IN,"google"))
        }
    }

    private fun phoneVerification(){
        if(viewModel.emailOrPhoneNo.get()!!.trim().isNotEmpty()) {
            PhoneAuthProvider.verifyPhoneNumber(
                PhoneAuthOptions
                    .newBuilder(FirebaseAuth.getInstance())
                    .setActivity(requireActivity())
                    .setPhoneNumber("+91"+viewModel.emailOrPhoneNo.get()!!.trim())
                    .setTimeout(60L, TimeUnit.SECONDS)
                    .setCallbacks(viewModel.callbacks)
                    .build()
            )
        }
    }

}