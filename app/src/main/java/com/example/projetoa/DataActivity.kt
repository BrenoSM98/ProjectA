package com.example.projetoa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DataActivity : AppCompatActivity() {
    private lateinit var textTextView: TextView
    private lateinit var nomeEditText: EditText
    private lateinit var idadeEditText: EditText
    private lateinit var sexoEditText: EditText
    private lateinit var cidadeEditText: EditText
    private lateinit var objetivoEditText: EditText
    private lateinit var confirmarButton: Button

    private val sharedPreferencesKey = "user_data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        textTextView = findViewById(R.id.textTextView)
        nomeEditText = findViewById(R.id.nomeEditText)
        idadeEditText = findViewById(R.id.idadeEditText)
        sexoEditText = findViewById(R.id.sexoEditText)
        cidadeEditText = findViewById(R.id.cidadeEditText)
        objetivoEditText = findViewById(R.id.objetivoEditText)
        confirmarButton = findViewById(R.id.confirmarButton)

        // Botão "Confirmar" para salvar os dados e navegar de volta para o perfil
        confirmarButton.setOnClickListener{
            val nome = nomeEditText.text.toString()
            val idade = idadeEditText.text.toString()
            val sexo = sexoEditText.text.toString()
            val cidade = cidadeEditText.text.toString()
            val objetivo = objetivoEditText.text.toString()

            // Acesso às preferências compartilhadas para armazenar os dados do usuário
            val sharedPreferences = getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("nome", nome)
            editor.putString("idade", idade)
            editor.putString("sexo", sexo)
            editor.putString("cidade", cidade)
            editor.putString("objetivo", objetivo)
            editor.apply()

            val intent = Intent(this, Profile::class.java)  // Navega para a atividade de perfil
            startActivity(intent)
            finish()   // Finaliza esta atividade para impedir a navegação de voltar para ela
        }
    }
}