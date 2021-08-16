package com.github.sampledagger2mvp

import android.app.Application
import com.github.sampledagger2mvp.di.component.ApplicationComponent
import com.github.sampledagger2mvp.di.component.DaggerApplicationComponent
import com.github.sampledagger2mvp.di.module.ApplicationModule

class DaggerMVPApplication:Application() {
    private lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent=DaggerApplicationComponent.builder().applicationModule(ApplicationModule()).build()
    }
}