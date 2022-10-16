package com.example.loginbanco

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Banco: AppCompatActivity() {
    private lateinit var  cbVerSaldo: CheckBox
    private lateinit var rbIngresar: RadioButton
    private lateinit var rbRetirar: RadioButton
    private lateinit var rbSalir: RadioButton
    private lateinit var tvVerSaldo: TextView
    private lateinit var etnIngresar: EditText
    private lateinit var etnRetirar: EditText
    private var saldo = 100.0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banco)

        cbVerSaldo = findViewById(R.id.cb_VerSaldo)
        rbIngresar = findViewById(R.id.rb_Ingresar)
        rbRetirar = findViewById(R.id.rb_Retirar)
        rbSalir = findViewById(R.id.rb_Salir)
        tvVerSaldo = findViewById(R.id.tv_VerSaldo)
        etnIngresar = findViewById(R.id.etn_Ingresar)
        etnRetirar = findViewById(R.id.etn_Retirar)

    }

    fun accion(v: View){
        tvVerSaldo.visibility = View.INVISIBLE
        etnIngresar.visibility = View.INVISIBLE
        etnRetirar.visibility = View.INVISIBLE
        if(cbVerSaldo.isChecked()==true){
            tvVerSaldo.visibility= View.VISIBLE
            tvVerSaldo.text="Su saldo es de:$${saldo} "

            if(rbIngresar.isChecked()==true){
                etnIngresar.visibility = View.VISIBLE

            }
            if(rbRetirar.isChecked()==true){
                etnRetirar.visibility = View.VISIBLE

            }
            if(rbSalir.isChecked()==true){
                tvVerSaldo.visibility = View.VISIBLE
                tvVerSaldo.text = "Bye Usuario"
                Toast.makeText(this, "Cerrando programa", Toast.LENGTH_SHORT).show()
            }

        }
    }
    fun procesar(Vista: View){
        tvVerSaldo.visibility = View.INVISIBLE
        etnIngresar.visibility = View.INVISIBLE
        etnRetirar.visibility = View.INVISIBLE
        if(cbVerSaldo.isChecked()==true){
            tvVerSaldo.visibility= View.VISIBLE
            tvVerSaldo.text="Su saldo es de:$${saldo} "
        }
        if(rbIngresar.isChecked()==true){
            etnIngresar.visibility = View.VISIBLE
            var ingresar = etnIngresar.text.toString().toDouble()
            saldo = saldo+ingresar
            tvVerSaldo.text= "Tu saldo es: $$saldo"
            Toast.makeText(this, "Su operacion se realizo con exito", Toast.LENGTH_SHORT).show()

        }
        if(rbRetirar.isChecked()==true){
            var retirar = etnRetirar.text.toString().toDouble()
            if(saldo-retirar<0.0) {
                tvVerSaldo.visibility = View.VISIBLE
                tvVerSaldo.text = "No posee suficeinte dinero en su cuenta"

            }else{
                saldo = saldo - retirar
                tvVerSaldo.text = "Tu saldo es: $$saldo"
                Toast.makeText(this, "Su operacion se realizo con exito", Toast.LENGTH_SHORT).show()
            }

        }
        if(rbSalir.isChecked()==true){
            tvVerSaldo.visibility = View.VISIBLE
            finish()
            System.exit(0)

        }

    }

}