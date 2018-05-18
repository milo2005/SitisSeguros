package mobile.sitis.seguros.ui.main

import android.arch.lifecycle.ViewModel
import mobile.sitis.seguros.data.db.AppDatabase
import mobile.sitis.seguros.data.db.SeguroDao
import mobile.sitis.seguros.data.model.Seguro
import kotlin.concurrent.thread

class MainViewModel: ViewModel(){

    val dao:SeguroDao = AppDatabase.db.seguroDao()

    fun listSeguro():List<Seguro> = dao.getAll()

    fun removeSeguro(seguro: Seguro, callback:(seguro:Seguro)->Unit){
        thread {
            dao.remove(seguro)
            callback(seguro)
        }
    }

    fun restoreSeguro(seguro: Seguro, callback: () -> Unit){
        thread {
            dao.insert(seguro)
            callback()
        }
    }

}