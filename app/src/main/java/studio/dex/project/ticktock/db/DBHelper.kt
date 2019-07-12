package studio.dex.project.ticktock.db

object DBHelper{
    lateinit var db:AppDataBase
    fun initDBHelper(param:AppDataBase){
        db =param
    }
}