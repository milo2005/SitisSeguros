package mobile.sitis.seguros.ui.main

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import mobile.sitis.seguros.R
import mobile.sitis.seguros.ui.adapters.SeguroAdapter
import mobile.sitis.seguros.ui.add.AddActivity
import mobile.sitis.seguros.util.LifeDisposable
import mobile.sitis.seguros.util.buildViewModel
import mobile.sitis.seguros.util.snackBarAction
import org.jetbrains.anko.contentView
import org.jetbrains.anko.startActivity
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val viewModel:MainViewModel by lazy { buildViewModel<MainViewModel>() }
    val adapter:SeguroAdapter = SeguroAdapter()

    val dis:LifeDisposable = LifeDisposable(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()

        btnAdd.setOnClickListener {startActivity<AddActivity>()}

        dis add viewModel.listSeguro()
                .subscribe {
                    adapter.data = it
                }

        dis add adapter.onRemove
                .flatMap { viewModel.removeSeguro(it) }
                .flatMap { snackBarAction(contentView!!, "Seguro Eliminado", "Deshacer", it ) }
                .flatMap { viewModel.restoreSeguro(it) }
                .subscribe()

    }




}
