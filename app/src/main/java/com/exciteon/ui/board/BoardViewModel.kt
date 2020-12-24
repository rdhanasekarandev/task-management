package com.exciteon.ui.board

import com.exciteon.ui.base.BaseViewModel
import com.exciteon.utils.resource.ResourceProvider
import javax.inject.Inject

class BoardViewModel @Inject constructor(val resourceProvider: ResourceProvider):
    BaseViewModel<BoardNavigator>() {
}