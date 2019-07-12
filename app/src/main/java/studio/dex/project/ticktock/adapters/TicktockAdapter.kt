package studio.dex.project.ticktock.adapters

import android.os.Handler
import android.os.Message
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import studio.dex.project.ticktock.R
import studio.dex.project.ticktock.TicktockBean
import studio.dex.project.ticktock.toast
import java.util.concurrent.Executors

class TicktockAdapter:BaseQuickAdapter<TicktockBean,BaseViewHolder>(R.layout.item_ticktock_layout){
    override fun convert(helper: BaseViewHolder?, item: TicktockBean?) {
        helper?.setText(R.id.nameTV, item?.name.toString())
    }
    val handler = Handler{
        notifyDataSetChanged()
        true
    }

}