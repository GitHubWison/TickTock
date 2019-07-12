package studio.dex.project.ticktock.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_ticktock_info_layout.*
import me.yokeyword.fragmentation.SupportFragment
import studio.dex.project.ticktock.R
import studio.dex.project.ticktock.TicktockBean
import studio.dex.project.ticktock.TicktockConst

class TicktockInfoFragment:SupportFragment(){
    companion object{
        fun start(fragment: SupportFragment,bean: TicktockBean?){
            fragment.start(TicktockInfoFragment().apply {
                arguments = Bundle().let {
                    it.putParcelable(TicktockConst.ADD_PARAMS_TAG,bean)
                    it
                }
            })

        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ticktock_info_layout,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        val param = arguments?.getParcelable<TicktockBean>(TicktockConst.ADD_PARAMS_TAG)
        if (param!=null) {
            hour_tv.text = param.hour.toString()
            min_tv.text = param.min.toString()
            sec_tv.text = param.sec.toString()
            name_tv.text = param.name.toString()
        }
    }
}