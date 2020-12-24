package com.exciteon.ui.projects

import com.exciteon.ui.base.BaseViewModel
import com.exciteon.utils.resource.ResourceProvider
import javax.inject.Inject

class ProjectsViewModel @Inject constructor(val resourceProvider: ResourceProvider):
    BaseViewModel<ProjectsNavigator>() {
}