package mobile.sitis.seguros.ui.add

import android.arch.lifecycle.ViewModel
import mobile.sitis.seguros.data.db.AppDatabase
import mobile.sitis.seguros.data.db.SeguroDao
import mobile.sitis.seguros.data.model.Seguro
import java.util.*
import kotlin.concurrent.thread

class AddViewModel:ViewModel(){

    private val dao:SeguroDao = AppDatabase.db.seguroDao()

    fun saveSeguro(aseguradora:String, beneficiario:String, fecha: Date,
                   callback:()->Unit){
        thread {
            dao.insert(Seguro(null, aseguradora, beneficiario, fecha))
            callback()
        }
    }

}