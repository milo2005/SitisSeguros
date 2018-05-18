package mobile.sitis.seguros.ui.add

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*
import mobile.sitis.seguros.R
import org.jetbrains.anko.toast

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnCancel.setOnClickListener{ finish() }
        btnOk.setOnClickListener {
            val aseguradoraValue = aseguradora.text.toString()
            val beneficiarioValue = beneficiario.text.toString()
            if(aseguradoraValue.isNotEmpty() && beneficiarioValue.isNotEmpty()){



            }else{
                toast("Debes diligenciar el formulario")
            }
        }
    }
}
