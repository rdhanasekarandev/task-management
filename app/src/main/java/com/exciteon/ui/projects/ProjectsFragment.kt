package com.exciteon.ui.projects

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
import com.exciteon.databinding.FragmentProjectsBinding
import com.exciteon.ui.base.BaseFragment
import com.exciteon.ui.board.BoardNavigator
import com.exciteon.ui.board.BoardViewModel
import javax.inject.Inject

class ProjectsFragment : BaseFragment<FragmentProjectsBinding, ProjectsViewModel>(), ProjectsNavigator {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_projects
    override val viewModel: ProjectsViewModel
        get() = ViewModelProviders.of(this, mViewModelFactory).get(ProjectsViewModel::class.java)
    lateinit var mBinding: FragmentProjectsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = viewDataBinding!!
    }
}