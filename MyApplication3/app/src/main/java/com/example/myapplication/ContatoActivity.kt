package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class ContatoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)

        botton_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()

                }
                R.id.ic_calculadora -> {
                    startActivity(Intent(this, CalcActivity::class.java))
                    finish()

                }
                R.id.ic_perfil -> {
                    startActivity(Intent(this, PerfilActivity::class.java))
                    finish()

                }
            }
            true
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onResume() {
        super.onResume()
        botton_nav.selectedItemId = R.id.ic_economizar
    }
}