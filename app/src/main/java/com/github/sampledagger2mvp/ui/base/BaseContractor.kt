package com.github.sampledagger2mvp.ui.base

class BaseContractor {
    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface  View{

    }

}