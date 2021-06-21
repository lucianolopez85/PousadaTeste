package com.example.pousadateste.ui

import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.pousadateste.R
import kotlinx.android.synthetic.main.activity_form_pagamento.*
import kotlinx.android.synthetic.main.pagamento.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class FormPagamento : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_pagamento)

        val valorCafe = 0.0
        var valorTotal = 0.0

        val imagemView: ImageView = findViewById(R.id.pag_imagem)
        val tipoQuartoView: TextView = findViewById(R.id.pag_tipo_quarto)
        val qtdHospedesView: TextView = findViewById(R.id.pag_qtd_hospede)
        val valorPorPessoaView: TextView = findViewById(R.id.pag_valor_hospedes)
        val valorCafeView: TextView = findViewById(R.id.pag_valor_cafe)
        val valorTotalView: TextView = findViewById(R.id.pag_valor_diaria)
        val dataChegadaView: TextView = findViewById(R.id.pag_data_chegada)
        val dataPartidaView: TextView = findViewById(R.id.pag_data_partida)

        val bundle: Bundle? = intent.extras
        val quarto = bundle!!.getString("tipoQuarto")
        val valorPorPessoa = bundle.getString("valorPorPessoa")
        val quantidadeHospedes = bundle.getString("quantidadeHospedes")
        val imagem = bundle.getInt("imagem")
        val dataChegada = bundle.getString("dataChegada")
        val dataPartida = bundle.getString("dataPartida")

        val formato = DateTimeFormatter.ofPattern("d/M/yyyy");
        val dataInicial = LocalDate.parse(dataChegada, formato)
        val dataFinal = LocalDate.parse(dataPartida, formato)
        val diferencaDias = ChronoUnit.DAYS.between(dataInicial, dataFinal).toInt()

        if (quantidadeHospedes!=null){
            valorTotal = (diferencaDias*quantidadeHospedes.toString().toDouble()*valorPorPessoa.toString().toDouble())+valorCafe
        }

        imagemView.setImageResource(imagem)
        tipoQuartoView.text = quarto
        qtdHospedesView.text = quantidadeHospedes.toString()
        valorPorPessoaView.text = valorPorPessoa
        valorCafeView.text = valorCafe.toString()
        valorTotalView.text = valorTotal.toString()
        dataChegadaView.text = dataChegada.toString()
        dataPartidaView.text = dataPartida.toString()

        irParaDialogPagamento()

    }

    private fun irParaDialogPagamento() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.pagamento, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Pagamento com cartão de crédito")
        pagar.setOnClickListener {
            builder.show()
        }
    }
}