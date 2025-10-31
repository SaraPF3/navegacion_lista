package es.etg.dam.navegacion_lista

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)

        val extras = intent.extras
        val id = extras!!.getString("id")
        val edad = extras!!.getInt("edad")
        val localidad = extras!!.getString("localidad")

        val msg = "$id $edad $localidad"

        val toast = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        toast.show()
    }
}