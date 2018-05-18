package mobile.sitis.seguros.ui.add

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.activity_add.*
import mobile.sitis.seguros.R
import mobile.sitis.seguros.util.LifeDisposable
import mobile.sitis.seguros.util.buildViewModel
import mobile.sitis.seguros.util.validateForm
import org.jetbrains.anko.toast
import java.util.*

class AddActivity : AppCompatActivity() {

    val viewModel:AddViewModel by lazy { buildViewModel<AddViewModel>() }

    val dis:LifeDisposable = LifeDisposable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnCancel.setOnClickListener{ finish() }

    }

    override fun onResume() {
        super.onResume()
        dis add btnOk.clicks()
                .flatMap { validateForm(this, "Llena los campos", aseguradora.text.toString()
                        , beneficiario.text.toString()) }
                .flatMap { viewModel.saveSeguro(it[0], it[1], Date()) }
                .subscribe {
                    toast("Seguro Insertado")
                    finish()
                }

    }

}
