package mobile.sitis.seguros.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mobile.sitis.seguros.R
import mobile.sitis.seguros.data.model.Seguro
import mobile.sitis.seguros.databinding.TemplateSeguroBinding

class SeguroAdapter:RecyclerView.Adapter<SeguroViewHolder>(){

    var data: List<Seguro> = emptyList()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeguroViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.template_seguro, parent, false)
        return  SeguroViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SeguroViewHolder, position: Int) {
        holder.bind(data[position], position, this)
    }

    fun removeSeguro(position:Int){

    }

}

class SeguroViewHolder(view: View):RecyclerView.ViewHolder(view){
    val binding:TemplateSeguroBinding = TemplateSeguroBinding.bind(view)

    fun bind(seguro:Seguro, position:Int,  adapter:SeguroAdapter){
        binding.seguro = seguro
        binding.position = position
        binding.handler = adapter

    }

}