package com.github.sampledagger2mvp.ui.topcommunity

import com.github.sampledagger2mvp.model.TopCommunities
import com.github.sampledagger2mvp.ui.base.BaseContractor

class TopCommunitiesContractor {

    interface View: BaseContractor.View{
        fun listTopCommunities(list:ArrayList<TopCommunities>)

    }


}