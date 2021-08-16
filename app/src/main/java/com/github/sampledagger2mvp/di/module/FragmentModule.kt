package com.github.sampledagger2mvp.di.module
import androidx.fragment.app.Fragment
import com.github.sampledagger2mvp.api.ApiServiceInterface
import com.github.sampledagger2mvp.ui.sports.SportsFragment
import com.github.sampledagger2mvp.ui.sports.SportsPresenter
import com.github.sampledagger2mvp.ui.topcommunity.TopCommunitiesFragment
import com.github.sampledagger2mvp.ui.topcommunity.TopCommunitiesPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(fragment: Fragment) {
    var frag=fragment
    @Provides
    fun provideTopCommunitiesPresenter(): TopCommunitiesPresenter {
        return TopCommunitiesPresenter(frag as TopCommunitiesFragment)
    }

    @Provides
    fun provideSportsPresenter(): SportsPresenter {
        return SportsPresenter(frag as SportsFragment)
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}