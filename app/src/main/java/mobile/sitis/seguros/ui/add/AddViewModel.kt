package mobile.sitis.seguros.ui.add

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobile.sitis.seguros.data.db.AppDatabase
import mobile.sitis.seguros.data.db.SeguroDao
import mobile.sitis.seguros.data.model.Seguro
import mobile.sitis.seguros.util.applySchdulers
import java.util.Date
import kotlin.concurrent.thread

class AddViewModel:ViewModel(){

    private val dao:SeguroDao = AppDatabase.db.seguroDao()

    fun saveSeguro(aseguradora:String, beneficiario:String, fecha: Date):Observable<Unit> = Observable.fromCallable{
        dao.insert(Seguro(null, aseguradora, beneficiario, fecha))
    }
            .applySchdulers()



}