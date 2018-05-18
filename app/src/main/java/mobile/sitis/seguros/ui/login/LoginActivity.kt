package mobile.sitis.seguros.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_login.*
import mobile.sitis.seguros.R
import mobile.sitis.seguros.ui.main.MainActivity
import mobile.sitis.seguros.util.LifeDisposable
import mobile.sitis.seguros.util.buildViewModel
import mobile.sitis.seguros.util.validateForm
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    private val viewModel:LoginViewModel by lazy{ buildViewModel<LoginViewModel>() }

    val dis:LifeDisposable = LifeDisposable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(viewModel.isLogged()){
            startActivity<MainActivity>()
            finish()
            return
        }

        setContentView(R.layout.activity_login)

    }

    override fun onResume() {
        super.onResume()
        dis add btnIn.clicks()
                .validateForm(this, "Datos incompletos",usr.text.toString(), pass.text.toString())
                .subscribe{
                    viewModel.login(it[0], it[1])
                    startActivity<MainActivity>()
                    finish()
                }

    }

}
