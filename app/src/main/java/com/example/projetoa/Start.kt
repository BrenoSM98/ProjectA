package com.example.projetoa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Start : AppCompatActivity() {
    private lateinit var textViewResult: TextView
    private lateinit var buttonCalcular: Button
    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var textViewResult2: TextView
    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        editTextAltura = findViewById(R.id.editTextAltura)
        editTextPeso = findViewById(R.id.editTextPeso)
        buttonCalcular = findViewById(R.id.buttonCalcular)
        textViewResult = findViewById(R.id.textViewResult)
        textViewResult2 = findViewById(R.id.textViewResult2)
        buttonNext = findViewById(R.id.buttonNext)

        buttonCalcular.setOnClickListener{
            val altura = editTextAltura.text.toString().toDouble()
            val peso =editTextPeso.text.toString().toDouble()

            val imc = calcularIMC(altura, peso)

            textViewResult.text = String.format("Seu IMC é %.2f",imc)

            val mensagem = when {
                imc < 18.5 -> "Seu IMC é de grau 0; MAGREZA."
                imc < 24.9 -> "Seu IMC é de grau 0; NORMAL."
                imc < 30 -> "Seu IMC é  de grau 1; SOBREPESO."
                imc < 39.9 -> "Seu IMC é de grau 2; OBESIDADE."
                else -> "Seu IMC é de grau 3; OBESIDADE GRAVE."
            }

            textViewResult2.text = mensagem

            buttonNext.visibility = View.VISIBLE

            buttonNext.setOnClickListener{
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
    }
}
    private fun calcularIMC(altura: Double, peso: Double): Double {
        return peso / (altura * altura)
    }
}