package com.example.pousadateste.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.pousadateste.R
import com.google.firebase.auth.FirebaseAuth
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
        alertDialogParaDeslogar()

        location.setOnClickListener {
            val intent = Intent(this, Maps::class.java)
            startActivity(intent)
        }
    }

    private fun alertDialogParaDeslogar() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Deseja desconectar?")
        exit.setOnClickListener {
            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                deslogar()
                voltarTelaLogin()
            }
            builder.setNegativeButton(android.R.string.no) { dialog, which ->
            }
            builder.show()
        }
    }

    private fun deslogar() {
        FirebaseAuth.getInstance().signOut()
    }

    private fun voltarTelaLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
    }
}
