package mobile.sitis.seguros.util

import android.content.Context
import io.reactivex.Observable
import org.jetbrains.anko.toast

fun <T>Observable<T>.validateForm(context: Context,msg:String, vararg field:String):Observable<List<String>> =
        flatMap {value-> Observable.create<List<String>>{
                if(field.contains("")) context.toast(msg)
                else it.onNext(field.toList())
                it.onComplete()
            }
        }
