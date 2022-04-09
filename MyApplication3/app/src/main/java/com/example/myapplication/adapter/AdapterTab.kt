package com.example.myapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.adapter.fragment.ArtigosFragment
import com.example.myapplication.adapter.fragment.ConhecaFragment
import com.example.myapplication.adapter.fragment.GuiasFragment

class AdapterTab(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return ArtigosFragment()
            1 -> return ConhecaFragment()
            2 -> return GuiasFragment()
            else -> return ArtigosFragment()
        }
    }
}