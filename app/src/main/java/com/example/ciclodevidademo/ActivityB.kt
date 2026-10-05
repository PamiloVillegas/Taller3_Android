package com.example.ciclodevidademo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    companion object {
        private const val TAG = "CicloVida"
    }

    private lateinit var textoRecibido: TextView

    private val resultadoDeC =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { resultado ->

            if (resultado.resultCode == RESULT_OK) {

                val numeroModificado =
                    resultado.data?.getIntExtra("numeroModificado", 0)

                textoRecibido.text =
                    "Número recibido de C: $numeroModificado"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_b)

        Log.d(TAG, "B - onCreate")

        textoRecibido = findViewById(R.id.textoRecibido)

        val botonIrAC = findViewById<Button>(R.id.botonIrAC)

        val mensaje = intent.getStringExtra("mensaje")

        textoRecibido.text = mensaje

        botonIrAC.setOnClickListener {

            val numero = 10

            val intent = Intent(this, ActivityC::class.java)

            intent.putExtra("numero", numero)

            resultadoDeC.launch(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "B - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "B - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "B - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "B - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "B - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "B - onDestroy")
    }
}