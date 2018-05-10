package mobile.sitis.seguros.ui.main

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import mobile.sitis.seguros.R
import mobile.sitis.seguros.util.buildViewModel

class MainActivity : AppCompatActivity() {

    val viewModel:MainViewModel by lazy { buildViewModel<MainViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.info.observe(this, Observer {
            txt.text = it
        })

        btnAdd.setOnClickListener {
            viewModel.changeInfo("Como Estan")
        }

    }
}
