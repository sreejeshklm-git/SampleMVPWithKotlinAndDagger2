package com.github.sampledagger2mvp.ui.topcommunity
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
import com.github.sampledagger2mvp.model.TopCommunities
import javax.inject.Inject


class TopCommunitiesFragment : Fragment(),TopCommunitiesContractor.View {
    @Inject
    lateinit var presenter: TopCommunitiesPresenter
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
        var  rootView = inflater!!.inflate(R.layout.fragment_top_communities, container, false)
        rView=rootView.findViewById(R.id.recyclerView)
        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadTopCommunities()

    }
    private fun injectDependency() {
        val topCommunitiesComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule(this))
            .build()

        topCommunitiesComponent.inject(this)
    }

    override fun listTopCommunities(list:ArrayList<TopCommunities>) {
        Log.e("called","top communities")
        var adapter = TopCommunitiesAdapter(requireActivity(), list.toMutableList(), this)
        rView!!.setLayoutManager(LinearLayoutManager(activity))
        Log.e("called","top communities")
        rView!!.setAdapter(adapter)

    }



}