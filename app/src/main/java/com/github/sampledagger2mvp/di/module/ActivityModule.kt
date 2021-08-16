package com.github.sampledagger2mvp.di.module

import android.app.Activity
import com.github.sampledagger2mvp.ui.main.MainActivity
import com.github.sampledagger2mvp.ui.main.MainContractor
import com.github.sampledagger2mvp.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity)
{
      var act=activity
    @Provides
    fun providePresenter():MainPresenter{
        return MainPresenter(act as MainActivity)
    }
    @Provides
    fun simpleString():String {
        return "simple String"
    }
}