package com.example.pousadateste.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pousadateste.R
import com.example.pousadateste.model.Data


class MyAdapter(
    private val arrayListData: ArrayList<Data>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var myListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_publicacao_quarto, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = arrayListData[position]
        holder.imagemView.setImageResource(data.imagem)
        holder.tituloView.text = data.titulo
        holder.comentariosView.text = data.comentario
        holder.hospedesView.text = data.qtdHospede.toString()
        holder.qtdeCamaView.text = data.qtdCama
        holder.valorView.text = data.valor
    }

    override fun getItemCount(): Int {
        return arrayListData.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val imagemView: ImageView = itemView.findViewById(R.id.imagem_quarto)
        val tituloView: TextView = itemView.findViewById(R.id.titulo_quarto)
        val comentariosView: TextView = itemView.findViewById(R.id.comentarios)
        val hospedesView: TextView = itemView.findViewById(R.id.qtd_hospedes)
        val qtdeCamaView: TextView = itemView.findViewById(R.id.qtd_cama)
        val valorView: TextView = itemView.findViewById(R.id.valor_anuncio)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}