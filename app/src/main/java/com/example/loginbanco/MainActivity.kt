//Stephanie Rodriguez
package com.example.loginbanco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity  : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etContraseña: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etNombre = findViewById(R.id.et_Nombre)
        etContraseña = findViewById(R.id.et_Contraseña)



    }
    fun Registrar (viste: View){
        //Conversion
        val nombre = etNombre.text.toString()
        val Contraseña = etContraseña.text.toString()

        if (nombre.length==0){
            Toast.makeText(this, "Tiene que ingresar un nombre", Toast.LENGTH_LONG).show()
        }
        if (Contraseña.length==0){
            Toast.makeText(this, "Tiene que ingresar su Contraseña", Toast.LENGTH_LONG).show()
        }

        if (nombre.length!=0 && Contraseña.length!=0){
            Toast.makeText(this, "Registro en proceso...", Toast.LENGTH_LONG).show()
            if(nombre=="Emerson" && Contraseña=="Fortnite"){
                Toast.makeText(this, "Bienvenido al sistema Bancario $nombre", Toast.LENGTH_LONG).show()
                val vBanco: Intent = Intent(this, Banco::class.java)
                startActivity(vBanco)
            }else{
                Toast.makeText(this, "Usuario incorrecto $nombre", Toast.LENGTH_LONG).show()
            }
        }



    }
}