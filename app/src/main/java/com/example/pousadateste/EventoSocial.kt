package com.example.pousadateste

import android.annotation.SuppressLint
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.pousadateste.adapter.PostsAdapter
import com.example.pousadateste.adapter.PostsAdapter2
import kotlinx.android.synthetic.main.activity_evento_social.*

class EventoSocial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evento_social)

        val posts: ArrayList<Int> = ArrayList()
        posts.add(R.drawable.casamento_duo)
        posts.add(R.drawable.casamento_all)

        recycler_img_first_line.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recycler_img_first_line.adapter = PostsAdapter(posts)

        val posts2: ArrayList<Int> = ArrayList()
        posts2.add(R.drawable.casamento_cobertura_1)
        posts2.add(R.drawable.casamento_cobertura_2)

        recycler_img_second_line.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recycler_img_second_line.adapter = PostsAdapter2(posts2)


    }
}