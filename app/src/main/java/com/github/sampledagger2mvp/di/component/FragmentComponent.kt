package com.github.sampledagger2mvp.di.component

import com.github.sampledagger2mvp.di.module.ApplicationModule
import com.github.sampledagger2mvp.di.module.FragmentModule
import com.github.sampledagger2mvp.ui.sports.SportsFragment
import com.github.sampledagger2mvp.ui.topcommunity.TopCommunitiesFragment
import dagger.Component

@Component(modules= arrayOf(FragmentModule::class))
interface  FragmentComponent {
   fun  inject(topCommunitiesFragment: TopCommunitiesFragment)
   fun  inject(sportsFragment: SportsFragment)
}