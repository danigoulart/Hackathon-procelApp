package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.model.Estados
import com.example.myapplication.model.Produto
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_calc.*
import kotlinx.android.synthetic.main.activity_calc.botton_nav
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_quiz.*
import java.math.RoundingMode
import java.text.DecimalFormat

class CalcActivity : AppCompatActivity() {

    var estadoSelecionado: Estados? = null
    var produtoSelecionado: Produto? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        botton_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> {

                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()

                }
                R.id.ic_economizar -> {

                    startActivity(Intent(this, ContatoActivity::class.java))
                    finish()

                }
                R.id.ic_perfil -> {

                    startActivity(Intent(this, PerfilActivity::class.java))
                    finish()

                }
            }
            true
        }

        bt_calcular.setOnClickListener {
            val tempo = input_tempo.text
            if (!tempo.isNullOrEmpty() || estadoSelecionado?.kw != null || produtoSelecionado?.kw != null) {
                var tempo = input_tempo.text.toString().toInt()
                val total = produtoSelecionado!!.kw!! * tempo * estadoSelecionado!!.kw!!
                onSNACK(it, total)
            }
        }
        var categoria: List<Produto> = mutableListOf(
            Produto(
                "Produto", null
            ),
            Produto(
            "Frost Free Duplex 441 litros", 0.77f
        ),    Produto(
                "Microondas 31l", 1.4f
            ),   Produto(
                "Máquina de Lavar 12kg", 0.37f
            )
        )

        var estados: MutableList<Estados> = mutableListOf()
        estados.add(Estados("Estado", "Estado", null))
        estados.add(Estados("AC", "Acre", 0.640f))
        estados.add(Estados("AL", "Alagoas", 0.626f))
        estados.add(Estados("AP", "Amapá", 0.505f))
        estados.add(Estados("AM", "Amazonas", 0.804f))
        estados.add(Estados("BA", "Bahia", 0.620f))
        estados.add(Estados("CE", "Ceará", 0.589f))
        estados.add(Estados("DF", "Distrito Federal", 0.575f))
        estados.add(Estados("ES", "Espírito Santo", 0.611f))
        estados.add(Estados("GO", "Goiás", 0.637f))
        estados.add(Estados("MA", "Maranhão", 0.642f))
        estados.add(Estados("MT", "Mato Grosso", 0.684f))
        estados.add(Estados("MS", "Mato Grosso do Sul", 0.694f))
        estados.add(Estados("MG", "Minas Gerais", 0.618f))
        estados.add(Estados("PA", "Pará", 0.766f))
        estados.add(Estados("PB", "Paraíba", 0.619f))
        estados.add(Estados("PR", "Paraná", 0.559f))
        estados.add(Estados("PE", "Pernambuco", 0.619f))
        estados.add(Estados("PI", "Piauí", 0.628f))
        estados.add(Estados("RJ", "Rio de Janeiro", 0.694f))
        estados.add(Estados("RN", "Rio Grande do Norte", 0.559f))
        estados.add(Estados("RS", "Rio Grande do Sul", 0.630f))
        estados.add(Estados("RO", "Rondônia", 0.546f))
        estados.add(Estados("RR", "Roraima", 0.580f))
        estados.add(Estados("SC", "Santa Catarina", 0.532f))
        estados.add(Estados("SP", "São Paulo", 0.594f))
        estados.add(Estados("SE", "Sergipe", 0.580f))
        estados.add(Estados("TO", "Tocantins", 0.668f))
//        spinner_Calc.adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, categoria )

        val spinnerCategoria =
            object : ArrayAdapter<Produto>(this, android.R.layout.simple_spinner_item, categoria) {
                override fun isEnabled(position: Int): Boolean {
                    // Disable the first item from Spinner
                    // First item will be used for hint
                    return position != 0
                }

                override fun getDropDownView(
                    position: Int,
                    convertView: View?,
                    parent: ViewGroup
                ): View {
                    val view: TextView =
                        super.getDropDownView(position, convertView, parent) as TextView
                    //set the color of first item in the drop down list to gray
                    if (position == 0) {
                        view.setTextColor(Color.GRAY)
                    } else {
                        //here it is possible to define color for other items by
                        //view.setTextColor(Color.RED)
                    }
                    return view
                }
            }

        spinnerCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_Calc.adapter = spinnerCategoria

        spinner_Calc.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if (value == categoria[0].toString()) {
                    (view as TextView).setTextColor(Color.GRAY)
                }
                produtoSelecionado = categoria[position]
            }

        }


        val spinnerEstado =
            object : ArrayAdapter<Estados>(this, android.R.layout.simple_spinner_item, estados) {
                override fun isEnabled(position: Int): Boolean {
                    // Disable the first item from Spinner
                    // First item will be used for hint
                    return position != 0
                }

                override fun getDropDownView(
                    position: Int,
                    convertView: View?,
                    parent: ViewGroup
                ): View {
                    val view: TextView =
                        super.getDropDownView(position, convertView, parent) as TextView
                    //set the color of first item in the drop down list to gray
                    if (position == 0) {
                        view.setTextColor(Color.GRAY)
                    } else {
                        //here it is possible to define color for other items by
                        //view.setTextColor(Color.RED)
                    }
                    return view
                }
            }

        spinnerEstado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_Estado.adapter = spinnerEstado

        spinner_Estado.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position) as Estados
                if (value.estado == estados[0].estado) {
                    (view as TextView).setTextColor(Color.GRAY)
                }
                estadoSelecionado = estados[position]
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    fun onSNACK(view: View, total: Float) {
        //Snackbar(view)
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        val snackbar = Snackbar.make(
            view, "Consumo de energia: R$ ${df.format(total)}",
            Snackbar.LENGTH_LONG
        ).setAction("Action", null)
        snackbar.setActionTextColor(resources.getColor(R.color.white))
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(resources.getColor(R.color.bg_yellow))

        val textView =
            snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(resources.getColor(R.color.white))
        textView.textSize = 20f
        snackbar.show()
    }

    override fun onResume() {
        super.onResume()
        botton_nav.selectedItemId = R.id.ic_calculadora
    }
}