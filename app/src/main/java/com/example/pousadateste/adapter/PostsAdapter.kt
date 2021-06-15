package com.example.pousadateste.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pousadateste.R


class PostsAdapter(
    val posts: ArrayList<Int>
): RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
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