package mobile.sitis.seguros.ui.login

import android.arch.lifecycle.ViewModel
import mobile.sitis.seguros.data.preferences.UserSession

class LoginViewModel: ViewModel(){

    fun login(username:String, password:String){
        UserSession.username = username
        UserSession.password = password
        UserSession.logged = true
    }

    fun isLogged():Boolean = UserSession.logged
}
