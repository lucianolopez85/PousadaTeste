package com.example.pousadateste.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pousadateste.databinding.ActivityFormCadastroBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener {
            val email = binding.editEmailCadastrar.text.toString()
            val senha = binding.editSenhaCadastrar.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos campos", Toast.LENGTH_SHORT).show()
            } else {
                cadastrarUsuario()
            }
        }
    }

    private fun cadastrarUsuario() {
        val email = binding.editEmailCadastrar.text.toString()
        val senha = binding.editSenhaCadastrar.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG)
                        .show()
                    binding.editEmailCadastrar.setText("")
                    binding.editSenhaCadastrar.setText("")
                }
            }.addOnFailureListener {
//            Toast.makeText(this, "Erro ao cadastrar usuário", Toast.LENGTH_LONG).show()

            var erro = it  //captura o erro

            when {
                // FirebaseAuthWeakPasswordException  <= exception do Firebase, senha com minimo de 6 caracteres
                erro is FirebaseAuthWeakPasswordException ->
                    Toast.makeText(
                        this,
                        "Digite uma senha com no mínimo 6 caracteres",
                        Toast.LENGTH_LONG
                    ).show()
                erro is FirebaseAuthUserCollisionException ->
                    Toast.makeText(this, "Esta conta já foi cadastrada", Toast.LENGTH_LONG).show()
                erro is FirebaseNetworkException ->
                    Toast.makeText(this, "Sem conexão com internet", Toast.LENGTH_LONG).show()
                // é necessário por permisão para internet no manifest (linha5)
                else -> Toast.makeText(this, "Erro ao cadastrar usuário", Toast.LENGTH_LONG).show()
            }

        }
    }
}