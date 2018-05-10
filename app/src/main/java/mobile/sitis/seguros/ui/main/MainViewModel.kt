package mobile.sitis.seguros.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel: ViewModel(){

    val info:MutableLiveData<String> = MutableLiveData()

    fun changeInfo(info:String){
        this.info.value = info
    }

}