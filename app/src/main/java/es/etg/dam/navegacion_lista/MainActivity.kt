package es.etg.dam.navegacion_lista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val boton: Button = findViewById(R.id.btnShow)

        boton.setOnClickListener { view ->
            val intent = Intent(this, SegundaActivity::class.java).apply{
                putExtra("id", "usuario123");
                putExtra("edad", 42);
                putExtra("localidad", "Parla");
            }
            startActivity(intent);
        }


    }
}