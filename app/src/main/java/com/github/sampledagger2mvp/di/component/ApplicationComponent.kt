package com.github.sampledagger2mvp.di.component

import com.github.sampledagger2mvp.di.module.ApplicationModule
import dagger.Component

@Component(modules= arrayOf(ApplicationModule::class))
interface ApplicationComponent {
}