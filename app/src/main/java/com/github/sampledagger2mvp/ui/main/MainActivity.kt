package com.github.sampledagger2mvp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.sampledagger2mvp.R
import com.github.sampledagger2mvp.di.component.DaggerActivityComponent
import com.github.sampledagger2mvp.di.module.ActivityModule
import com.github.sampledagger2mvp.ui.sports.SportsFragment
import com.github.sampledagger2mvp.ui.topcommunity.TopCommunitiesFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContractor.View, MainContractor.FetchString {
    @Inject
    lateinit var simpleString: String

    @Inject
    lateinit var mainPresenter: MainPresenter

    private var currentFragmnet: Fragment? = null
    private var topCommunitiesFragment: TopCommunitiesFragment? = null
    private var sportsFragment: SportsFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()
        topCommunitiesFragment = TopCommunitiesFragment()
        sportsFragment = SportsFragment()
        var tvTop = findViewById(R.id.top) as TextView
        var tvSports = findViewById(R.id.sports) as TextView
        activityComponent.inject(this)

        mainPresenter.showTopCommunities()
        tvTop.setOnClickListener(View.OnClickListener {
            currentFragmnet = topCommunitiesFragment
            mainPresenter.showFragment()
        })
        tvSports.setOnClickListener(View.OnClickListener {
            // mainPresenter.showString()
            currentFragmnet = sportsFragment
            mainPresenter.showFragment()
        })

    }

    override fun showTopCommunities() {
        topCommunitiesFragment = TopCommunitiesFragment()
        currentFragmnet = topCommunitiesFragment
        supportFragmentManager.beginTransaction()
            .add(R.id.main_fragmnt, topCommunitiesFragment!!)
            .commit()
    }

    override fun showFragment() {

        hideAllFragmentsAndShowCurrent()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragmnt, currentFragmnet!!)
            .commit()
    }

    override fun showString() {
        Log.e("injected string", simpleString)
    }


    private fun hideAllFragmentsAndShowCurrent() {
        if (topCommunitiesFragment != null) {
            supportFragmentManager.beginTransaction().hide(topCommunitiesFragment!!)
        }
        if (sportsFragment != null) {
            supportFragmentManager.beginTransaction().hide(sportsFragment!!)
        }

        supportFragmentManager.beginTransaction().show(currentFragmnet!!)
    }
}