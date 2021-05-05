package com.example.pousadateste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_categoria_acomodacoes.*
import kotlinx.android.synthetic.main.activity_menu_principal.*

class MenuPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        apartamentos.setOnClickListener {
            val intent = Intent(this, CategoriaAcomodacoes::class.java)
            startActivity(intent)
        }
        lazer.setOnClickListener {
            val intent = Intent(this, Lazer::class.java)
            startActivity(intent)
        }
        eventos_sociais.setOnClickListener {
            val intent = Intent(this, EventoSocial::class.java)
            startActivity(intent)
        }
    }
}