package com.example.pousadateste

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.ListView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_form_reserva.*
import java.util.*

class FormReserva : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_reserva)

        btn_confir_pagar.setOnClickListener {
            val intent = Intent(this, FormPagamento::class.java)
            startActivity(intent)

        }

        val c = Calendar.getInstance()
        val ano = c.get(Calendar.YEAR)
        val mes = c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH)

        btn_chegada.setOnClickListener {
            val click = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                edit_chegada.setText( "" + dayOfMonth + "/" + month + "/" + year)
            }, ano, mes, dia)
            click.show()
        }
    }
}