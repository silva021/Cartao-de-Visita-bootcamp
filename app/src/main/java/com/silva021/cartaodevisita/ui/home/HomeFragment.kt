package com.silva021.cartaodevisita.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.silva021.cartaodevisita.R
import com.silva021.cartaodevisita.databinding.FragmentHomeBinding
import com.silva021.cartaodevisita.domain.model.User
import com.silva021.cartaodevisita.ui.home.adapter.CardVisitAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModelHome: HomeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
        setupObserver()
        viewModelHome.getListCardVisit()

    }

    private fun setupListener() {
        binding.buttonAddCardVisit.setOnClickListener {
            findNavController().navigate(R.id.fragment_card_visit)
        }
    }

    private fun setupObserver() {
        viewModelHome.listCardVisit.observe(viewLifecycleOwner, {
            val adapter = CardVisitAdapter(it)
            binding.recyler.adapter = adapter
        })
    }

}