package com.exciteon.ui.home

import com.exciteon.ui.base.BaseViewModel
import com.exciteon.utils.resource.ResourceProvider
import javax.inject.Inject

class HomeViewModel @Inject constructor(val resourceProvider: ResourceProvider) :
    BaseViewModel<HomeNavigator>() {
}