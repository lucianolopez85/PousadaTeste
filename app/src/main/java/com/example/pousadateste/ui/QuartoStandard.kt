package com.example.pousadateste.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pousadateste.R
import com.example.pousadateste.adapter.MyAdapter
import com.example.pousadateste.model.Data

class QuartoStandard : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<Data>
    lateinit var listaDeImagensQuarto: Array<Int>
    lateinit var listaTituloQuarto: Array<String>
    lateinit var listaDeComentariosQuarto: Array<String>
    lateinit var listaDeQtdeHospedesQuarto: Array<Int>
    lateinit var listaDeQtdeCamaQuarto: Array<String>
    lateinit var listaValorQuarto: Array<String>
    lateinit var listaValorQuartoPorPessoa: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_quarto)

        listaDeImagensQuarto = arrayOf(
            R.drawable.quarto_casal_modelo_europeu,
            R.drawable.quarto_casal,
            R.drawable.quarto_solteiro_triplo,
            R.drawable.quarto_solteiro_duplo
        )
        listaTituloQuarto = arrayOf(
            "Quarto de casal Europeu",
            "Quarto de casal",
            "Quarto de solteiro triplo",
            "Quarto de solteiro duplo"
        )
        listaDeComentariosQuarto = arrayOf(
            "4,93 (107 comentários)",
            "4,91 (87 comentários)",
            "4,94 (56 comentários)",
            "4,88 (47 comentários)"
        )
        listaDeQtdeHospedesQuarto = arrayOf(
            2,
            2,
            3,
            2
        )
        listaDeQtdeCamaQuarto = arrayOf(
            "1 quarto - 1 cama - 1 banheiro",
            "1 quarto - 1 cama - 1 banheiro",
            "1 quarto - 3 camas - 1 banheiro",
            "1 quarto - 2 camas - 1 banheiro"
        )
        listaValorQuarto = arrayOf(
            "R$ 520/noite",
            "R$ 480/noite",
            "R$ 450/noite",
            "R$ 300/noite"
        )
        listaValorQuartoPorPessoa = arrayListOf(
            "260.00",
            "240.00",
            "150.00",
            "150.00"
        )

        recyclerView = findViewById(R.id.recycler_view_lista_quarto)
        arrayList = arrayListOf()

        getUserdata()
    }
    private fun getUserdata() {
        for (i in listaDeImagensQuarto.indices) {
            val listas = Data(
                listaDeImagensQuarto[i],
                listaTituloQuarto[i],
                listaDeComentariosQuarto[i],
                listaDeQtdeHospedesQuarto[i],
                listaDeQtdeCamaQuarto[i],
                listaValorQuarto[i],
                listaValorQuartoPorPessoa[i]
            )
            arrayList.add(listas)
        }

        val adapter = MyAdapter(arrayList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@QuartoStandard,"testando ${position}", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@QuartoStandard, FormReserva::class.java )
                intent.putExtra("listaQuarto", arrayList[position].titulo)
                intent.putExtra("listaValorPorPessoa", arrayList[position].valorUnitario)
                intent.putExtra("listaQtdHospedes", arrayList[position].qtdHospede)
//                intent.putExtra("listImageId",arrayList[position].image)

                startActivity(intent)
            }
        })
    }
}


