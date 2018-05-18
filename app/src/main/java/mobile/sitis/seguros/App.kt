package mobile.sitis.seguros

import android.app.Application
import mobile.sitis.seguros.data.db.AppDatabase
import mobile.sitis.seguros.data.preferences.UserSession

class App:Application(){

    override fun onCreate() {
        super.onCreate()
        UserSession.init(this)
        AppDatabase.init(this)
    }

}