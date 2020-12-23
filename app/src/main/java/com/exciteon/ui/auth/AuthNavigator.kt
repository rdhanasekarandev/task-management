package com.exciteon.ui.auth

import com.exciteon.ui.auth.AuthViewModel

interface AuthNavigator {

    fun navigateToScreen(screen: AuthViewModel.Screen, vararg params:String?)

}