package com.github.sampledagger2mvp.ui.topcommunity

import android.util.Log
import com.github.sampledagger2mvp.api.ApiServiceInterface
import com.github.sampledagger2mvp.model.TopCommunities
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await
class TopCommunitiesPresenter(view: TopCommunitiesFragment) {

    var v = view
    var list: ArrayList<TopCommunities>? = ArrayList()
    fun loadTopCommunities() {

        GlobalScope.launch(Dispatchers.Main) {
            val topCommunities = v.api.getCommunities().await()
            for (i in 0..20) {
                list!!.add(topCommunities[i])
            }
            v.listTopCommunities(list!!)
        }
    }

}