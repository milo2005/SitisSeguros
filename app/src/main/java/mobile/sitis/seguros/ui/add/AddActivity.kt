package mobile.sitis.seguros.ui.add

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*
import mobile.sitis.seguros.R
import mobile.sitis.seguros.util.buildViewModel
import org.jetbrains.anko.toast
import java.util.*

class AddActivity : AppCompatActivity() {

    val viewModel:AddViewModel by lazy { buildViewModel<AddViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnCancel.setOnClickListener{ finish() }

        btnOk.setOnClickListener {
            val aseguradoraValue = aseguradora.text.toString()
            val beneficiarioValue = beneficiario.text.toString()
            if(aseguradoraValue.isNotEmpty() && beneficiarioValue.isNotEmpty()){

                viewModel.saveSeguro(aseguradoraValue, beneficiarioValue, Date()){
                    runOnUiThread{
                        toast("Seguro Insertado")
                        finish()
                    }
                }

            }else{
                toast("Debes diligenciar el formulario")
            }
        }
    }
}
