package com.github.sampledagger2mvp.ui.sports

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.sampledagger2mvp.R
import com.github.sampledagger2mvp.api.ApiServiceInterface
import com.github.sampledagger2mvp.di.component.DaggerFragmentComponent
import com.github.sampledagger2mvp.di.module.FragmentModule
import com.github.sampledagger2mvp.model.SportsCommunities
import javax.inject.Inject

class SportsFragment : Fragment(),SportsContractor.View {
    @Inject
    lateinit var presenter: SportsPresenter
    @Inject
    lateinit var api: ApiServiceInterface
    var rView:RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDependency()


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        var  rootView = inflater!!.inflate(R.layout.fragment_sports_communities, container, false)
        rView=rootView.findViewById(R.id.recyclerView)
        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadSportsCommunities()

    }
    private fun injectDependency() {
        val fragmentComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule(this))
            .build()

        fragmentComponent.inject(this)
    }

    override fun listSportsCommunities(list:ArrayList<SportsCommunities>) {
        Log.e("called","top communities")
        var adapter = SportsAdapter(requireActivity(), list.toMutableList(), this)
        rView!!.setLayoutManager(LinearLayoutManager(activity))
        Log.e("called","top communities")
        rView!!.setAdapter(adapter)

    }




}