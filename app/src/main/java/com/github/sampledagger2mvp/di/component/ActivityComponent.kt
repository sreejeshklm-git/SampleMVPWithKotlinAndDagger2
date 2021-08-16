package com.github.sampledagger2mvp.di.component

import com.github.sampledagger2mvp.di.module.ActivityModule
import com.github.sampledagger2mvp.ui.main.MainActivity
import dagger.Component

@Component(modules= arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity:MainActivity)
}