package com.example.pousadateste.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pousadateste.R
import kotlinx.android.synthetic.main.activity_categoria_acomodacoes.*

class CategoriaAcomodacoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria_acomodacoes)

        categoria_standard.setOnClickListener {
            val intent = Intent(this, QuartoStandard::class.java)
            startActivity(intent)


        }
    }
}