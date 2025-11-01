# Navegación e intercambio de datos

Hecho por Sara Pérez Fernández

> El link del repositorio es: <https://github.com/SaraPF3/navegacion_lista>

La primera pantalla tiene tres cajas en las que se puede introducir información y un botón para navegar a la segunda pantalla:

```kt
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
        val editText = findViewById<EditText>(R.id.edtxtId)
        val idTexto = editText.text.toString()

        val txtEdad = findViewById<EditText>(R.id.edtxtEdad)
        val edad = txtEdad.text.toString()

        val txtLocalidad = findViewById<EditText>(R.id.edtxtLocalidad)
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
```

El xml de la primera pantalla es:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:textAlignment="center"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/txtAc1"
        android:textSize="34sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.164" />

    <Button
        android:id="@+id/btnShow"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="160dp"
        android:layout_marginBottom="160dp"
        android:text="@string/btnShow"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="@+id/edtxtLocalidad"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/edtxtLocalidad"
        app:layout_constraintVertical_bias="0.555" />

    <EditText
        android:id="@+id/edtxtEdad"
        android:layout_width="240dp"
        android:layout_height="60dp"
        android:layout_marginTop="20dp"
        android:ems="10"
        android:hint="@string/edad"
        android:textAlignment="textStart"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="@+id/edtxtId"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/edtxtId"
        app:layout_constraintTop_toBottomOf="@+id/edtxtId" />

    <EditText
        android:id="@+id/edtxtLocalidad"
        android:layout_width="240dp"
        android:layout_height="60dp"
        android:layout_marginTop="20dp"
        android:ems="10"
        android:hint="@string/localidad"
        android:textAlignment="textStart"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="@+id/edtxtEdad"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/edtxtEdad"
        app:layout_constraintTop_toBottomOf="@+id/edtxtEdad" />

    <EditText
        android:id="@+id/edtxtId"
        android:layout_width="240dp"
        android:layout_height="60dp"
        android:layout_marginTop="56dp"
        android:ems="10"
        android:hint="@string/usuario"
        android:inputType="text"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="@+id/textView"
        app:layout_constraintHorizontal_bias="0.504"
        app:layout_constraintStart_toStartOf="@+id/textView"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

La segunda pantalla obtiene los datos introducidos en la primera pantalla:

```kt
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
```

El xml de la segunda pantalla:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SegundaActivity">

    <EditText
        android:id="@+id/edtxtLocalidad2"
        android:layout_width="210dp"
        android:layout_height="60dp"
        android:layout_marginTop="40dp"
        android:ems="10"
        android:hint="@string/localidad"
        android:inputType="text"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="@+id/edtxtEdad2"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/edtxtEdad2"
        app:layout_constraintTop_toBottomOf="@+id/edtxtEdad2" />

    <EditText
        android:id="@+id/edtxtId2"
        android:layout_width="210dp"
        android:layout_height="60dp"
        android:layout_marginTop="220dp"
        android:ems="10"
        android:hint="@string/usuario"
        android:inputType="text"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="@+id/textView2"
        app:layout_constraintHorizontal_bias="0.507"
        app:layout_constraintStart_toStartOf="@+id/textView2"
        app:layout_constraintTop_toBottomOf="@+id/textView2" />

    <EditText
        android:id="@+id/edtxtEdad2"
        android:layout_width="210dp"
        android:layout_height="60dp"
        android:layout_marginTop="32dp"
        android:ems="10"
        android:hint="@string/edad"
        android:inputType="number"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="@+id/edtxtId2"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="@+id/edtxtId2"
        app:layout_constraintTop_toBottomOf="@+id/edtxtId2" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/txtAc2"
        android:textSize="34sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.172" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

Los valores de los elementos son:

```xml
<resources>
    <string name="app_name">navegacion_lista</string>
    <string name="txtAc1">Activity 1</string>
    <string name="txtAc2">Activity 2</string>
    <string name="edad">edad</string>
    <string name="localidad">localidad</string>
    <string name="btnShow">Show</string>
    <string name="usuario">nombre</string>
</resources>
```