package com.jaiswal.behance

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jaiswal.behance.viewmodels.MainActivityViewModel
import com.jaiswal.behance.viewmodels.ProjectDetialsViewModel

class ViewModelFactory private constructor(
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MainActivityViewModel::class.java) ->
                    MainActivityViewModel(application)
                isAssignableFrom(ProjectDetialsViewModel::class.java) ->
                    ProjectDetialsViewModel(application)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        lateinit var application: Application
        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                Companion.application = application
                INSTANCE ?: ViewModelFactory()
                    .also { INSTANCE = it }
            }


        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}