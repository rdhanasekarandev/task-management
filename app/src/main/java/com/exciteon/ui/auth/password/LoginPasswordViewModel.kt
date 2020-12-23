package com.exciteon.ui.auth.password

import androidx.databinding.ObservableField
import com.exciteon.ui.auth.AuthNavigator
import com.exciteon.ui.base.BaseViewModel
import com.exciteon.utils.resource.ResourceProvider
import javax.inject.Inject

class LoginPasswordViewModel @Inject constructor(resourceProvider: ResourceProvider): BaseViewModel<AuthNavigator>(){

    val password = ObservableField("")
    val resource = resourceProvider

    fun isValidPassword():Int{
        return if(password.get()!!.trim().length<7){
            0
        }else{
            1
        }
    }

}