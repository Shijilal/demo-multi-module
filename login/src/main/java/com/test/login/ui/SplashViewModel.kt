package com.test.login.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.test.core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SplashViewModel @Inject constructor(
@Named("LoginLogger") private val logger: Logger
) : ViewModel() {

    init {
        logger.log("Checking Logger..123")
        Log.e("TAG", "Checking Log..456")
    }
}