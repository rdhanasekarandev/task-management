package com.exciteon.ui.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.exciteon.BR
import com.exciteon.R
import com.exciteon.databinding.FragmentBoardBinding
import com.exciteon.databinding.FragmentTasksBinding
import com.exciteon.ui.base.BaseFragment
import com.exciteon.ui.board.BoardNavigator
import com.exciteon.ui.board.BoardViewModel
import javax.inject.Inject

class TasksFragment : BaseFragment<FragmentTasksBinding, TasksViewModel>(), TasksNavigator {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_tasks
    override val viewModel: TasksViewModel
        get() = ViewModelProviders.of(this, mViewModelFactory).get(TasksViewModel::class.java)
    lateinit var mBinding: FragmentTasksBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = viewDataBinding!!
    }
}