package mobile.sitis.seguros.ui.main

import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.Observable
import mobile.sitis.seguros.data.db.AppDatabase
import mobile.sitis.seguros.data.db.SeguroDao
import mobile.sitis.seguros.data.model.Seguro
import mobile.sitis.seguros.util.applySchdulers

class MainViewModel: ViewModel(){

    val dao:SeguroDao = AppDatabase.db.seguroDao()

    fun listSeguro(): Flowable<List<Seguro>> = dao.list()
            .applySchdulers()


    fun removeSeguro(seguro: Seguro): Observable<Seguro> = Observable.fromCallable {
        dao.remove(seguro)
        seguro
    }
            .applySchdulers()


    fun restoreSeguro(seguro: Seguro): Observable<Unit> = Observable.fromCallable {
        dao.insert(seguro)
    }
            .applySchdulers()

}