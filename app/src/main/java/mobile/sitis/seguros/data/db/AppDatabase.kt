package mobile.sitis.seguros.data.db

import android.arch.persistence.room.*
import android.content.Context
import mobile.sitis.seguros.data.model.Seguro
import java.util.*

class DateConverter{

    @TypeConverter
    fun dateToLong(date: Date):Long = date.time


    @TypeConverter
    fun longToDate(long:Long):Date = Date(long)

}

@TypeConverters(DateConverter::class)
@Database(version = 1, entities = [Seguro::class])
abstract class AppDatabase: RoomDatabase(){

    abstract fun seguroDao():SeguroDao

    companion object {
        lateinit var db:AppDatabase
        fun init(context: Context){
            db = Room.databaseBuilder(context,AppDatabase::class.java,"seguros.db" )
                    .build()
        }
    }
}