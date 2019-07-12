package studio.dex.project.ticktock.db

import android.arch.persistence.room.*
import studio.dex.project.ticktock.TicktockBean

@Database(version = 1, entities = [TicktockBean::class])
abstract class AppDataBase : RoomDatabase() {
    abstract fun ticktockDao(): TicktockDao
}

@Dao
interface TicktockDao {
    @Query("select * from TicktockBean")
    fun findAllTicktock(): List<TicktockBean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bean: TicktockBean)

    @Query("delete from TicktockBean where uuid =  :uuid")
    fun delete(uuid: String)
}