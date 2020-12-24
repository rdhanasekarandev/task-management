package com.exciteon.ui.home

import com.exciteon.ui.board.BoardFragment
import com.exciteon.ui.projects.ProjectsFragment
import com.exciteon.ui.tasks.TasksFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class HomeFragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideBoardFragmentFactory():BoardFragment

    @ContributesAndroidInjector
    abstract fun provideTasksFragmentFactory():TasksFragment

    @ContributesAndroidInjector
    abstract fun provideProjectsFragmentFactory():ProjectsFragment

}