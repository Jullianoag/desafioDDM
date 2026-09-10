package br.unisanta.desafioDDM.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.desafioDDM.R
import br.unisanta.desafioDDM.dao.FilmeDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CadastroActivity : AppCompatActivity(R.layout.activity_cadastro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtTitulo = findViewById<EditText>(R.id.edt_titulo)
        val edtGenero = findViewById<EditText>(R.id.edt_genero)
        val edtUrl = findViewById<EditText>(R.id.edt_url)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca_cadastro)
        val fabFechar = findViewById<FloatingActionButton>(R.id.fab_fechar_cadastro)

        btnSalvar.setOnClickListener{
            val titulo = edtTitulo.text.toString()
            val genero = edtGenero.text.toString()
            val url = edtUrl.text.toString()

            val retorno = FilmeDAO.salvar(titulo, genero, url)
            Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
        }

        fabAvanca.setOnClickListener{
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

        fabFechar.setOnClickListener{
            finish()
        }

    }
}