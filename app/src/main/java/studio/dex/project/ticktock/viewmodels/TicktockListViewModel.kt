package studio.dex.project.ticktock.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.dex.toolslibrary.setLiveData
import studio.dex.project.ticktock.Repository
import studio.dex.project.ticktock.TicktockBean

class TicktockListViewModel:ViewModel(){
    val listLiveData = MutableLiveData<List<TicktockBean>>()
    fun findAll(){
        listLiveData.setLiveData(Repository.findAllTicktockList())
    }
}