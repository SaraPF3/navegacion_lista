package es.etg.dam.navegacion_lista

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(MainActivity.ID)
            val edad = extras.getString(MainActivity.EDAD)
            val localidad = extras.getString(MainActivity.LOCALIDAD)

            val txtId = findViewById<EditText>(R.id.edtxtId2)
            val txtEdad = findViewById<EditText>(R.id.edtxtEdad2)
            val txtLocalidad = findViewById<EditText>(R.id.edtxtLocalidad2)

            txtId.setText(id)
            txtEdad.setText(edad)
            txtLocalidad.setText(localidad)

        }
    }
}