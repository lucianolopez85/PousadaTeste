package com.example.pousadateste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class LayoutEntrada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_entrada)

        Handler(Looper.getMainLooper()).postDelayed({
            AbrirTelaLogin() //metodo para duração do tempo
        }, 2000)
    }
    private fun AbrirTelaLogin(){
        val intent = Intent(this, CategoriaAcomodacoes::class.java)
        startActivity(intent)
        finish()
    }
}