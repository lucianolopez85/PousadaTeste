package com.example.pousadateste.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.pousadateste.R
import kotlinx.android.synthetic.main.activity_form_reserva.*
import java.util.*

class FormReserva : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_reserva)

        val quartoView: TextView = findViewById(R.id.form_tipo_de_quarto)
        val valorUnitario: TextView = findViewById(R.id.valor_diaria_por_pessoa_form)
//        val imageView: ImageView = findViewById(R.id.imageView)

        val bundle: Bundle? = intent.extras
        val quarto = bundle!!.getString("listaQuarto")
        val valorPorPessoa = bundle.getString("listaValorPorPessoa")
//        val imageId = bundle.getInt("listImageId")
//        val detail = bundle.getString("listData")

        quartoView.text = quarto
        valorUnitario.text = valorPorPessoa
//        detailView.text = detail
//        imageView.setImageResource(imageId)

        btn_confir_pagar.setOnClickListener {
            val intent = Intent(this, FormPagamento::class.java)
            startActivity(intent)
        }

        val c= Calendar.getInstance()
        val ano = c.get(Calendar.YEAR)
        val mes = c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH)

        btn_chegada.setOnClickListener {
            val click = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                data_chegada_form.setText( "" + dayOfMonth + "/" + month + "/" + year)
            }, ano, mes, dia)
            click.show()
        }
        btn_partida.setOnClickListener {
            val click = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                data_partida_form.setText( "" + dayOfMonth + "/" + month + "/" + year)
            }, ano, mes, dia)
            click.show()
        }
    }
}