package com.github.sampledagger2mvp.ui.sports

import android.util.Log
import com.github.sampledagger2mvp.api.ApiServiceInterface
import com.github.sampledagger2mvp.model.SportsCommunities
import com.github.sampledagger2mvp.model.TopCommunities
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import retrofit2.await
class SportsPresenter(view: SportsFragment) {

    var v = view
    var list: ArrayList<SportsCommunities>? = ArrayList()
    fun loadSportsCommunities() {

        GlobalScope.launch(Dispatchers.Main) {
            val sportsCommunities = v.api.getSportsCommunities().await()
            for (i in 0..20) {
                list!!.add(sportsCommunities[i])
            }
            v.listSportsCommunities(list!!)
        }
    }

}