package studio.dex.project.ticktock

import android.arch.lifecycle.MutableLiveData
import studio.dex.project.ticktock.db.DBHelper
import java.util.concurrent.Executors

object Repository{
    private val executorService = Executors.newCachedThreadPool()
    private val db  = DBHelper.db
    fun findAllTicktockList():MutableLiveData<List<TicktockBean>>{
        return MutableLiveData<List<TicktockBean>>().apply {
            executorService.execute {
                val res = db.ticktockDao().findAllTicktock()
               this.postValue(res)
            }

        }
    }
    fun saveTicktock(param:TicktockBean)
    {
        executorService.execute {
            db.ticktockDao().insert(param)
        }

    }
}