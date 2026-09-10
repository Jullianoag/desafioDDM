package br.unisanta.desafioDDM.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.desafioDDM.R
import br.unisanta.desafioDDM.adapter.FilmeAdapter
import br.unisanta.desafioDDM.dao.FilmeDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity(R.layout.activity_lista) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvLista = findViewById<RecyclerView>(R.id.rv_lista)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar_lista)


        rvLista.adapter = FilmeAdapter(FilmeDAO.obter())
        rvLista.layoutManager = LinearLayoutManager(this)

        fabVoltar.setOnClickListener{
            finish()
        }
    }
}