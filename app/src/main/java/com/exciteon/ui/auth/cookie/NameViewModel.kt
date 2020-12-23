package com.exciteon.ui.auth.cookie

import androidx.databinding.ObservableField
import com.exciteon.ui.auth.AuthNavigator
import com.exciteon.ui.base.BaseViewModel
import com.exciteon.utils.resource.ResourceProvider
import javax.inject.Inject

class NameViewModel @Inject constructor(val resourceProvider: ResourceProvider):
    BaseViewModel<AuthNavigator>(){

    val firstName = ObservableField("")
    val lastName = ObservableField("")
}