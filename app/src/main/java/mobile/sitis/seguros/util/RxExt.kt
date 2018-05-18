package mobile.sitis.seguros.util

import android.content.Context
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.toast

fun validateForm(context: Context,msg:String, vararg field:String):Observable<List<String>> =
        Observable.create<List<String>>{
                if(field.contains("")) context.toast(msg)
                else it.onNext(field.toList())
                it.onComplete()
            }

fun <T>Observable<T>.applySchdulers():Observable<T> = compose{ it.
        subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.applySchdulers():Single<T> = compose{ it.
        subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Maybe<T>.applySchdulers():Maybe<T> = compose{ it.
        subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T>Flowable<T>.applySchdulers():Flowable<T> = compose{ it.
        subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

