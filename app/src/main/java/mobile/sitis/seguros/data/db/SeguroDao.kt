package mobile.sitis.seguros.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import mobile.sitis.seguros.data.model.Seguro

@Dao
interface SeguroDao{

    @Insert
    fun insert(seguro: Seguro)

    @Update
    fun update(seguro:Seguro)

    @Delete
    fun remove(seguro:Seguro)

    @Query("SELECT * FROM seguro WHERE id = :id")
    fun getById(id:Long):Seguro

    @Query("SELECT * FROM seguro")
    fun getAll():List<Seguro>

    @Query("SELECT * FROM seguro")
    fun list(): LiveData<List<Seguro>>
}