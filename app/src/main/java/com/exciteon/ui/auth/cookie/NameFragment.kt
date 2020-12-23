package com.exciteon.ui.auth.cookie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.exciteon.BR
import com.exciteon.R
import com.exciteon.databinding.FragmentNameBinding
import com.exciteon.ui.auth.AuthViewModel
import com.exciteon.ui.base.BaseFragment
import com.exciteon.utils.AuthUiEvent
import com.exciteon.utils.RxBus
import com.exciteon.utils.onClick
import javax.inject.Inject

class NameFragment : BaseFragment<FragmentNameBinding, NameViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_name
    override val viewModel: NameViewModel
        get() = ViewModelProvider(this,viewModelFactory).get(NameViewModel::class.java)
    private lateinit var mBinding:FragmentNameBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = viewDataBinding!!
        initView()
        viewModel.firstName.set("")
        viewModel.lastName.set("")
    }

    private fun initView(){
        mBinding.authFinish.onClick {
            when {
                viewModel.firstName.get()!!.trim().isEmpty() -> {
                    showSnackBar(getString(R.string.invalid),getString(R.string.firstname_should_not_be_empty),"")
                }
                viewModel.lastName.get()!!.trim().isEmpty() -> {
                    showSnackBar(getString(R.string.invalid),getString(R.string.lastname_should_not_be_empty),"")
                }
                else -> {
                    mBinding.authFinish.visibility = View.GONE
                    mBinding.progressBar.visibility = View.VISIBLE
                    RxBus.publish(AuthUiEvent.Navigate(AuthViewModel.Screen.HOME_NAME,viewModel.firstName.get()!!.trim(),viewModel.lastName.get()!!.trim()))
                }
            }
        }
    }
}