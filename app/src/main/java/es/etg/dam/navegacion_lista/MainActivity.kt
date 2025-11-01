package es.etg.dam.navegacion_lista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val boton: Button = findViewById(R.id.btnShow)

        boton.setOnClickListener { view ->
            navegar()
        }
    }
    fun navegar(){
        val editText = findViewById<TextView>(R.id.edtxtId)
        val idTexto = editText.text.toString()

        val txtEdad = findViewById< TextView>(R.id.edtxtEdad)
        val edad = txtEdad.text.toString()

        val txtLocalidad = findViewById< TextView>(R.id.edtxtLocalidad)
        val localidad = txtLocalidad.text.toString()


        val intent = Intent(this, SegundaActivity::class.java).apply {
            putExtra(MainActivity.ID, idTexto);
            putExtra(MainActivity.EDAD, edad);
            putExtra(MainActivity.LOCALIDAD, localidad);
        }
        startActivity(intent);
    }
    companion object{
        const val ID = "id"
        const val EDAD = "edad"
        const val LOCALIDAD = "localidad"
    }
}