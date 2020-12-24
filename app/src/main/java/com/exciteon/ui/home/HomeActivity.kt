package com.exciteon.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.exciteon.BR
import com.exciteon.R
import com.exciteon.databinding.ActivityHomeBinding
import com.exciteon.ui.base.BaseActivity
import com.exciteon.ui.board.BoardFragment
import com.exciteon.ui.projects.ProjectsFragment
import com.exciteon.ui.tasks.TasksFragment
import com.exciteon.utils.addFragmentToActivity
import com.exciteon.utils.replaceFragmentToActivity
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(),HomeNavigator{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_home
    override val viewModel: HomeViewModel
        get() = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    lateinit var mBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mBinding = viewDataBinding!!
        initView()
        entryPoint(savedInstanceState)
    }

    private fun initView() {
        topView = mBinding.root
        setUpBottomNavigation()

    }

    private fun entryPoint(savedInstanceState: Bundle?){
        if(savedInstanceState==null){
            addFragmentToActivity(mBinding.flAuth.id, ProjectsFragment(), "dashboard")
        }
    }

    private fun setUpBottomNavigation() {
        with(mBinding.bottomNavigation) {
            val item1 = AHBottomNavigationItem("Projects", R.drawable.app_icon)
            val item2 = AHBottomNavigationItem("Tasks", R.drawable.app_icon)
            val item3 = AHBottomNavigationItem("Board", R.drawable.app_icon)
            val item4 = AHBottomNavigationItem("Profile", R.drawable.app_icon)
            mBinding.bottomNavigation.addItem(item1)
            mBinding.bottomNavigation.addItem(item2)
            mBinding.bottomNavigation.addItem(item3)
            mBinding.bottomNavigation.addItem(item4)
            mBinding.bottomNavigation.titleState = AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE;
            accentColor = ContextCompat.getColor(context!!, R.color.app_button)
            inactiveColor = ContextCompat.getColor(context!!, R.color.grey)
            isColored = false
            titleState = AHBottomNavigation.TitleState.ALWAYS_HIDE
        }
        mBinding.bottomNavigation.setOnTabSelectedListener { position, wasSelected ->
            when(position){
                0 -> { moveToProjectsFragment() }
                1 -> { moveToTasksFragment() }
                2 -> { moveToBoardFragment() }
                3 -> { moveToProfileFragment() }
            }
            true
        }
        mBinding.bottomNavigation.setOnNavigationPositionListener {

        }
    }

    override fun moveToProfileFragment() {
//        replaceFragmentToActivity(mBinding.flAuth.id, ProfileFragment(), "dashboard")
    }

    override fun moveToTasksFragment() {
        replaceFragmentToActivity(mBinding.flAuth.id, TasksFragment(), "tasks")
    }

    override fun moveToProjectsFragment() {
        replaceFragmentToActivity(mBinding.flAuth.id, ProjectsFragment(), "projects")
    }

    override fun moveToBoardFragment() {
        replaceFragmentToActivity(mBinding.flAuth.id, BoardFragment(), "board")
    }

}