package com.example.pousadateste.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pousadateste.R
import kotlinx.android.synthetic.main.item_publicacao_quarto.view.*
import kotlinx.android.synthetic.main.item_evento_social.view.*



class PostsAdapter2(
    val posts2: ArrayList<Int>
): RecyclerView.Adapter<PostsAdapter2.ViewHolder>() {

    override fun getItemCount() = posts2.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts2[position]
        holder.firstFoto.setBackgroundResource(post)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_evento_social, parent, false)
        return ViewHolder(view)
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val firstFoto: ImageView = itemView.findViewById(R.id.img_item)

    }

}