package com.example.ciclodevidademo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityC : AppCompatActivity() {

    companion object {
        private const val TAG = "CicloVida"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_c)

        Log.d(TAG, "C - onCreate")

        val textoNumero = findViewById<TextView>(R.id.textoNumero)
        val botonModificar = findViewById<Button>(R.id.botonModificar)

        val numero = intent.getIntExtra("numero", 0)

        textoNumero.text = "Número recibido: $numero"

        botonModificar.setOnClickListener {

            val numeroModificado = numero * 2

            val resultado = Intent()

            resultado.putExtra("numeroModificado", numeroModificado)

            setResult(RESULT_OK, resultado)

            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "C - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "C - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "C - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "C - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "C - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "C - onDestroy")
    }
}