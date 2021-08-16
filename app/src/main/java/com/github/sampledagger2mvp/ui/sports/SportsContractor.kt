package com.github.sampledagger2mvp.ui.sports

import com.github.sampledagger2mvp.model.SportsCommunities
import com.github.sampledagger2mvp.ui.base.BaseContractor

class SportsContractor {

    interface View: BaseContractor.View{
        fun listSportsCommunities(list:ArrayList<SportsCommunities>)

    }


}