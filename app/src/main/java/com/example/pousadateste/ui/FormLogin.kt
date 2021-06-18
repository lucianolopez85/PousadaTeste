package com.example.pousadateste.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pousadateste.databinding.ActivityFormLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.android.synthetic.main.activity_form_login.*

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verificarUsuarioLogado()

        binding.btnEntrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos campos", Toast.LENGTH_SHORT).show()
            } else {
                AutenticarUsuario()
            }
        }
        txt_cadastre_se.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }
    }

    private fun AutenticarUsuario() {
        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                irParaTelaPrincipal()
            }
        }.addOnFailureListener {
//            Toast.makeText(this, "Erro ao logar", Toast.LENGTH_SHORT).show()
            var erro = it

            when {
                erro is FirebaseAuthInvalidCredentialsException ->
                    Toast.makeText(this, "E-mail ou senha incorreto", Toast.LENGTH_SHORT).show()
                erro is FirebaseNetworkException ->
                    Toast.makeText(this, "Sem conexão com internet", Toast.LENGTH_SHORT).show()
                else ->
                    Toast.makeText(this, "Erro ao logar usuário", Toast.LENGTH_SHORT)
                        .show() //erro global
            }
        }
    }

    private fun verificarUsuarioLogado() {
        // currentUser  <-- é o usuário em uso no momento
        val usuarioLogado = FirebaseAuth.getInstance().currentUser

        if (usuarioLogado != null) {
            irParaTelaPrincipal()
        }
    }

    private fun irParaTelaPrincipal() {
        val intent = Intent(this, MenuPrincipal::class.java)
        startActivity(intent)
        finish()
    }
}