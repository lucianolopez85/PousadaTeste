package com.example.pousadateste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_form_reserva.*

class FormReserva : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_reserva)

        btn_confir_pagar.setOnClickListener {
            val intent = Intent(this,FormPagamento::class.java)
            startActivity(intent)
        }
    }
}