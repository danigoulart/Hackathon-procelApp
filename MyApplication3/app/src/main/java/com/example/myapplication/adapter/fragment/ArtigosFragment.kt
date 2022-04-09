package com.example.myapplication.adapter.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.HomeDetalhe
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_artigos.*
import kotlinx.android.synthetic.main.fragment_artigos.view.*

class ArtigosFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artigos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.card_main.setOnClickListener {
            startActivity(Intent(requireContext(), HomeDetalhe::class.java))
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ArtigosFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}