package com.exciteon.ui.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.exciteon.BR
import com.exciteon.R
import com.exciteon.databinding.FragmentBoardBinding
import com.exciteon.ui.base.BaseFragment
import javax.inject.Inject

class BoardFragment : BaseFragment<FragmentBoardBinding, BoardViewModel>(),BoardNavigator {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_board
    override val viewModel: BoardViewModel
        get() = ViewModelProviders.of(this, mViewModelFactory).get(BoardViewModel::class.java)
    lateinit var mBinding: FragmentBoardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = viewDataBinding!!
    }
}