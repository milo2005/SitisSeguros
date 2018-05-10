package mobile.sitis.seguros.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import mobile.sitis.seguros.R
import mobile.sitis.seguros.ui.main.MainActivity
import mobile.sitis.seguros.util.buildViewModel
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    private val viewModel:LoginViewModel by lazy{ buildViewModel<LoginViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(viewModel.isLogged()){
            startActivity<MainActivity>()
            finish()
            return
        }

        setContentView(R.layout.activity_login)
        btnIn.setOnClickListener{
            viewModel.login(usr.text.toString(), pass.text.toString())
            startActivity<MainActivity>()
            finish()
        }
    }
}
