package com.example.projetoa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class DataActivity : AppCompatActivity() {
    private lateinit var textTextView: TextView
    private lateinit var nomeEditText: EditText
    private lateinit var idadeEditText: EditText
    private lateinit var sexoEditText: EditText
    private lateinit var cidadeEditText: EditText
    private lateinit var objetivoEditText: EditText
    private lateinit var confirmarButton: Button
    private lateinit var dadosViewModel: DadosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        dadosViewModel = ViewModelProvider(this).get(DadosViewModel::class.java)

        textTextView = findViewById(R.id.textTextView)
        nomeEditText = findViewById(R.id.nomeEditText)
        idadeEditText = findViewById(R.id.idadeEditText)
        sexoEditText = findViewById(R.id.sexoEditText)
        cidadeEditText = findViewById(R.id.cidadeEditText)
        objetivoEditText = findViewById(R.id.objetivoEditText)
        confirmarButton = findViewById(R.id.confirmarButton)

        confirmarButton.setOnClickListener{
            dadosViewModel.nome = nomeEditText.text.toString()
            dadosViewModel.idade = idadeEditText.text.toString()
            dadosViewModel.sexo = sexoEditText.text.toString()
            dadosViewModel.cidade = cidadeEditText.text.toString()
            dadosViewModel.objetivo = objetivoEditText.text.toString()


            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}