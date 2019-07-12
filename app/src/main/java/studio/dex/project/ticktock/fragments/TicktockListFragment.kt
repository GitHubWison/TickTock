package studio.dex.project.ticktock.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.*
import kotlinx.android.synthetic.main.activity_ticktock_list.*
import me.yokeyword.fragmentation.SupportActivity
import me.yokeyword.fragmentation.SupportFragment
import studio.dex.library.uilibrary.DividedGridItemDecoration
import studio.dex.project.ticktock.R
import studio.dex.project.ticktock.TicktockBean
import studio.dex.project.ticktock.adapters.TicktockAdapter
import studio.dex.project.ticktock.viewmodels.TicktockListViewModel

class TicktockListFragment : SupportFragment() {
    private var viewModel: TicktockListViewModel? = null
    private var adapter: TicktockAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_ticktock_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.add_ticktock -> {
                AddTicktockFragment.start(this, null)
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.tick_tock_type_menu, menu)
    }

    private fun initViews() {
        (activity as SupportActivity).setSupportActionBar(toolbar.apply {
            title = "列表"
            setHasOptionsMenu(true)
        })

        initAdapterAndData()

    }

    //    设置数据源和adapter
    private fun initAdapterAndData() {
        adapter = TicktockAdapter()
        adapter?.setOnItemClickListener { _, _, position ->
//            AddTicktockFragment.start(this, adapter?.data?.get(position))
            TicktockInfoFragment.start(this, adapter?.data?.get(position))
        }
        ticktockListRV.adapter = adapter
        val spanCount = 3
        ticktockListRV.layoutManager = GridLayoutManager(context, spanCount)
        ticktockListRV.addItemDecoration(DividedGridItemDecoration(spanCount, 20))
        viewModel = ViewModelProviders.of(this).get(TicktockListViewModel::class.java)

        viewModel?.listLiveData?.observe(this, Observer {
            adapter?.replaceData(it ?: ArrayList())
        })
    }

    override fun onResume() {
        super.onResume()
        refreshData()
    }

    override fun onFragmentResult(requestCode: Int, resultCode: Int, data: Bundle?) {
        super.onFragmentResult(requestCode, resultCode, data)
        refreshData()
    }

    private fun refreshData() {
        viewModel?.findAll()
    }


}