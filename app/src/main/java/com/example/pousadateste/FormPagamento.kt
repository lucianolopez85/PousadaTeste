package com.example.pousadateste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_form_pagamento.*
import kotlinx.android.synthetic.main.activity_form_reserva.*
import kotlinx.android.synthetic.main.activity_menu_principal.*

class FormPagamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_pagamento)

        pagar.setOnClickListener {
            val intent = Intent(this, MenuPrincipal::class.java)
            startActivity(intent)
        }
    }
}