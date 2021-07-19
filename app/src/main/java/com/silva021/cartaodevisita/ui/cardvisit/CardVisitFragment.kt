package com.silva021.cartaodevisita.ui.cardvisit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.silva021.cartaodevisita.databinding.FragmentCardVisitBinding

class CardVisitFragment : Fragment() {
    lateinit var binding: FragmentCardVisitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCardVisitBinding.inflate(inflater, container, false)
        return binding.root
    }


}