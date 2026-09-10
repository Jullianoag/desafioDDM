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
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtUsuario = findViewById<EditText>(R.id.edt_usuario)
        val edtSenha = findViewById<EditText>(R.id.edt_senha)
        val btnLogar = findViewById<Button>(R.id.btn_login)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca_login)

        btnLogar.setOnClickListener{
            val usuario = edtUsuario.text.toString()
            val senha = edtSenha.text.toString()

            if(usuario == "adm" && senha == "123"){
                val intent = Intent(this, CadastroActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Logado com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Credenciais incorretas!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}