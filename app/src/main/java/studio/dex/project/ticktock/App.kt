package studio.dex.project.ticktock

import android.annotation.SuppressLint
import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import studio.dex.project.ticktock.db.AppDataBase
import studio.dex.project.ticktock.db.DBHelper

class App : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        initRoom()
    }

    private fun initRoom() {
        DBHelper.initDBHelper(
            Room.databaseBuilder(this, AppDataBase::class.java, "project.ticktock.db")
                .build()
        )
    }
}