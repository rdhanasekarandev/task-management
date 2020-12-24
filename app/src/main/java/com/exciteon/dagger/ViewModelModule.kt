package com.exciteon.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.exciteon.AppViewModelFactory
import com.exciteon.dagger.ViewModelKey
import com.exciteon.ui.auth.AuthViewModel
import com.exciteon.ui.auth.cookie.NameViewModel
import com.exciteon.ui.auth.create.CreateViewModel
import com.exciteon.ui.auth.login.LoginViewModel
import com.exciteon.ui.auth.otp.CreateOtpViewModel
import com.exciteon.ui.auth.otp.LoginOtpViewModel
import com.exciteon.ui.auth.password.CreatePasswordViewModel
import com.exciteon.ui.auth.password.LoginPasswordViewModel
import com.exciteon.ui.board.BoardViewModel
import com.exciteon.ui.home.HomeViewModel
import com.exciteon.ui.home.HomeViewModel_Factory
import com.exciteon.ui.projects.ProjectsViewModel
import com.exciteon.ui.splash.SplashViewModel
import com.exciteon.ui.tasks.TasksViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginPasswordViewModel::class)
    abstract fun bindLoginPasswordViewModel(loginPasswordViewModel: LoginPasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginOtpViewModel::class)
    abstract fun bindLoginOtpViewModel(loginOtpViewModel: LoginOtpViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateViewModel::class)
    abstract fun bindCreateViewModel(createViewModel: CreateViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreatePasswordViewModel::class)
    abstract fun bindCreatePasswordViewModel(createPasswordViewModel: CreatePasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateOtpViewModel::class)
    abstract fun bindCreateOtpViewModel(createOtpViewModel: CreateOtpViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NameViewModel::class)
    abstract fun bindNameViewModel(nameViewModel: NameViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BoardViewModel::class)
    abstract fun bindBoardViewModel(boardViewModel: BoardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TasksViewModel::class)
    abstract fun bindTasksViewModel(tasksViewModel: TasksViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProjectsViewModel::class)
    abstract fun bindProjectsViewModel(projectsViewModel: ProjectsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}