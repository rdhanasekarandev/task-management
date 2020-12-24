package com.exciteon.ui.tasks

import com.exciteon.ui.base.BaseViewModel
import com.exciteon.ui.projects.ProjectsNavigator
import com.exciteon.utils.resource.ResourceProvider
import javax.inject.Inject

class TasksViewModel @Inject constructor(val resourceProvider: ResourceProvider):
    BaseViewModel<TasksNavigator>() {
}