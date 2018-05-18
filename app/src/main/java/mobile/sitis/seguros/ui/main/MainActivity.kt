package mobile.sitis.seguros.ui.main

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import mobile.sitis.seguros.R
import mobile.sitis.seguros.ui.adapters.SeguroAdapter
import mobile.sitis.seguros.ui.add.AddActivity
import mobile.sitis.seguros.util.buildViewModel
import org.jetbrains.anko.contentView
import org.jetbrains.anko.startActivity
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val viewModel:MainViewModel by lazy { buildViewModel<MainViewModel>() }
    val adapter:SeguroAdapter = SeguroAdapter(this::onRemoveSeguro)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.listSeguro().observe(this, Observer {
            adapter.data = it!!
        })

    }

    override fun onResume() {
        super.onResume()

        btnAdd.setOnClickListener {startActivity<AddActivity>()}

    }

    fun onRemoveSeguro(position:Int){
        viewModel.removeSeguro(adapter.data[position]){removed->
            Snackbar.make(contentView!!, "Seguro Eliminado", Snackbar.LENGTH_SHORT)
                    .setAction("Deshacer"){
                        viewModel.restoreSeguro(removed){}
                    }
                    .show()
        }
    }
}
