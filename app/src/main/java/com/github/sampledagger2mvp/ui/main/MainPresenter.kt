package com.github.sampledagger2mvp.ui.main

class MainPresenter(v: MainActivity) {

  var  view= v
  fun showString() {

         view.showString()
    }

    fun showTopCommunities(){
        view.showTopCommunities()
    }

    fun showFragment(){
        view.showFragment()
    }

}