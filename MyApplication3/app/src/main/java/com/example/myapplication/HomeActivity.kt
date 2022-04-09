package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.adapter.AdapterTab
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    var tabTitle = arrayOf("Artigos", "Conheça", "Guias")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var pager = findViewById<ViewPager2>(R.id.pager)
        var t1 = findViewById<TabLayout>(R.id.tab_layout)
        pager.adapter = AdapterTab(supportFragmentManager, lifecycle)
        botton_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_calculadora -> {
                    startActivity(Intent(this, CalcActivity::class.java))
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

        TabLayoutMediator(t1, pager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }

    override fun onResume() {
        super.onResume()
        botton_nav.selectedItemId = R.id.ic_home
    }

    fun callActivity() {
        startActivity(Intent(this, CalcActivity::class.java))
    }
}
