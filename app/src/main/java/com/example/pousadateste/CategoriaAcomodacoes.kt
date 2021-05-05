package com.example.pousadateste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_categoria_acomodacoes.*

class CategoriaAcomodacoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria_acomodacoes)

        categoria_standard.setOnClickListener {
            val intent = Intent(this, QuartoComSacada::class.java)
            startActivity(intent)


        }
    }
}