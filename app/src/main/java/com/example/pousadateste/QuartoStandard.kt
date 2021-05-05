package com.example.pousadateste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.example.pousadateste.adapter.MyAdapter

class QuartoStandard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_quarto)

        var listViewCreated = findViewById<ListView>(R.id.list_view)
        var list = mutableListOf<Model>()
        list.add(Model( "Quarto de casal Europeu", "4,93 (107 comentários)", R.drawable.quarto_casal_modelo_europeu))
        list.add(Model("Quarto de casal", "4,91 (87 comentários)", R.drawable.quarto_casal))
        list.add(Model("Quarto de solteiro triplo", "4,94 (56 comentários)", R.drawable.quarto_triplo))
        list.add(Model("Quarto de solteiro duplo", "4,88 (47 comentários)", R.drawable.quarto_solteiro_duplo))


        listViewCreated.adapter = MyAdapter(this, R.layout.activity_item_publicacao, list)

        listViewCreated.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id:Long ->
            if (position == 0){
                val intent = Intent(this,FormReserva::class.java)
                startActivity(intent)
            }
            if (position == 1){
                Toast.makeText(this, "teste", Toast.LENGTH_LONG).show()
            }
            if (position == 2){
                Toast.makeText(this, "teste", Toast.LENGTH_LONG).show()
            }
            if (position == 3){
                Toast.makeText(this, "teste", Toast.LENGTH_LONG).show()
            }


        }
    }
}