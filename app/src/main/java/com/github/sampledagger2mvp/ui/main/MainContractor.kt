package com.github.sampledagger2mvp.ui.main

import com.github.sampledagger2mvp.ui.base.BaseContractor

class MainContractor {

    interface FetchString {
        fun showString()
    }
    interface View:BaseContractor.View{
        fun showTopCommunities()
        fun showFragment()
    }
    interface  Presenter:BaseContractor.Presenter<MainContractor.View>{

    }
}