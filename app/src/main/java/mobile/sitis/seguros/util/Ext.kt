package mobile.sitis.seguros.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity

inline fun <reified T: ViewModel> AppCompatActivity.buildViewModel():T{
    return ViewModelProviders.of(this).get(T::class.java)
}