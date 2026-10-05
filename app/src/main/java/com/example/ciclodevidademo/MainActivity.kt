package com.example.ciclodevidademo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "CicloVida"
    }

    private var contadorActual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        Log.d(TAG, "A - onCreate")

        contadorActual = savedInstanceState?.getInt("contador") ?: 0

        val textoContador = findViewById<TextView>(R.id.textoContador)
        val botonContador = findViewById<Button>(R.id.botonContador)
        val botonIrAB = findViewById<Button>(R.id.botonIrAB)

        textoContador.text = "Contador: $contadorActual"

        botonContador.setOnClickListener {

            contadorActual++

            textoContador.text = "Contador: $contadorActual"
        }

        botonIrAB.setOnClickListener {

            val mensaje = "Hola desde Activity A"

            val intent = Intent(this, ActivityB::class.java)

            intent.putExtra("mensaje", mensaje)

            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("contador", contadorActual)

        Log.d(TAG, "A - onSaveInstanceState: contador=$contadorActual")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "A - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "A - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "A - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "A - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "A - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "A - onDestroy")
    }
}