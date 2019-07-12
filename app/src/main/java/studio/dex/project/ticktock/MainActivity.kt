package studio.dex.project.ticktock

import android.os.Bundle
import me.yokeyword.fragmentation.SupportActivity
import studio.dex.project.ticktock.fragments.TicktockListFragment
class MainActivity : SupportActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadRootFragment(R.id.mainFL,TicktockListFragment())
    }
}




