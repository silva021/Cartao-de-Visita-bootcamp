package com.silva021.cartaodevisita.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.silva021.cartaodevisita.R
import com.silva021.cartaodevisita.databinding.FragmentHomeBinding
import com.silva021.cartaodevisita.domain.model.People
import com.silva021.cartaodevisita.ui.home.adapter.CardVisitAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CardVisitAdapter(
            listOf(
                People("Lucas",
                    "21 995999584",
                    "lucasssilva021@gmail.com",
                    "MovilePay"),
                People("Diego",
                    "21 995999584",
                    "diego@gmail.com",
                    "Nasajon")
            )
        )

        binding.recyler.adapter = adapter

        binding.buttonAddCardVisit.setOnClickListener {
            findNavController().navigate(R.id.fragment_card_visit)
        }
    }

}