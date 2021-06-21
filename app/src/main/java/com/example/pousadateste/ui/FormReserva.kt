package com.example.pousadateste.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.pousadateste.R
import kotlinx.android.synthetic.main.activity_form_reserva.*
import kotlinx.android.synthetic.main.item_publicacao_quarto.*
import java.util.*

class FormReserva : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.N)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_reserva)

        val c = Calendar.getInstance()
        val ano = c.get(Calendar.YEAR)
        val mes = c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH)

        btn_chegada.setOnClickListener {
            val click = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    edit_data_chegada.setText("" + dayOfMonth + "/" + month + "/" + year)
                },ano, mes, dia
            )
            click.show()
        }

        btn_partida.setOnClickListener {
            val click = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    edit_data_partida.setText("" + dayOfMonth + "/" + month + "/" + year)
                },ano, mes, dia
            )
            click.show()
        }

        val quartoView: TextView = findViewById(R.id.form_tipo_de_quarto)
        val valorUnitario: TextView = findViewById(R.id.valor_diaria_por_pessoa_form)

        val bundle: Bundle? = intent.extras
        val quarto = bundle!!.getString("listaQuarto")
        val valorPorPessoa = bundle.getString("listaValorPorPessoa")
        val quantidadeHospedes = bundle.getInt("listaQtdHospedes")
        val imagem = bundle.getInt("listImagem")

        quartoView.text = quarto
        valorUnitario.text = valorPorPessoa.toString()
        btn_confir_pagar.setOnClickListener {

            val nomeUsuario = edit_nome_reserva.text.toString()
            val qtdHospedes = edit_quantidade_hospedes.text.toString()
            val dataChegada = edit_data_chegada.text.toString()
            val dataPartida = edit_data_partida.text.toString()

//   ####### PARA TESTES ############
            val intent = Intent(this, FormPagamento::class.java)
            intent.putExtra("imagem", imagem)
            intent.putExtra("tipoQuarto", quarto)
            intent.putExtra("valorPorPessoa", valorPorPessoa)
            intent.putExtra("quantidadeHospedes", qtdHospedes)
            intent.putExtra("dataChegada", dataChegada)
            intent.putExtra("dataPartida", dataPartida)
            startActivity(intent)

//            Log.d("***quantidadeHospedes", quantidadeHospedes.toString())
//            Log.d("***qtdHospedes", qtdHospedes)

//            if (nomeUsuario.isEmpty() || qtdHospedes.isEmpty() || dataChegada.isEmpty() || dataPartida.isEmpty() ){
//                Toast.makeText(this, "Favor preencher todos os campos!", Toast.LENGTH_SHORT).show()
//            }else if (quantidadeHospedes < qtdHospedes.toInt() ){
//                Toast.makeText(this, "Limite máximo de ${quantidadeHospedes} hospedes", Toast.LENGTH_SHORT).show()
//            }else{
//                startActivity(intent)
//            }
        }
    }

}