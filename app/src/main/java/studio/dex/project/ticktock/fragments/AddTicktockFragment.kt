package studio.dex.project.ticktock.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import kotlinx.android.synthetic.main.activity_setting_layout.*
import me.yokeyword.fragmentation.SupportFragment
import studio.dex.project.ticktock.R
import studio.dex.project.ticktock.Repository
import studio.dex.project.ticktock.TicktockBean
import studio.dex.project.ticktock.TicktockConst

class AddTicktockFragment : SupportFragment() {

    companion object {
        fun start(fragment: SupportFragment, bean: TicktockBean?) {
            fragment.startForResult(AddTicktockFragment().apply { arguments = Bundle().let {
                it.putParcelable(TicktockConst.ADD_PARAMS_TAG, bean)
                it } }, 1001)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_setting_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initData()
    }

    private fun initData() {

        val params = arguments?.getParcelable<TicktockBean>(TicktockConst.ADD_PARAMS_TAG)
        if (params != null) {
            npHour.value = params.hour ?: 0
            npSec.value = params.sec ?: 0
            npMin.value = params.min ?: 0
            etName.setText(params.name ?: "")
        }
    }

    private fun initViews() {
        configNumberPicker(npHour, 0, 24)
        configNumberPicker(npMin, 0, 60)
        configNumberPicker(npSec, 0, 60)
        btSure.setOnClickListener {
            Repository.saveTicktock(
                TicktockBean.generate(
                    npHour.value,
                    npMin.value,
                    npSec.value,
                    etName.text.toString()))
            pop()
        }
    }

    private fun configNumberPicker(n: NumberPicker, min: Int, max: Int) {
        n.minValue = min
        n.maxValue = max
    }
}