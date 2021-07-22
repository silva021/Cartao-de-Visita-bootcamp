package com.silva021.cartaodevisita.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.silva021.cartaodevisita.CardVisitApplication
import com.silva021.cartaodevisita.R
import com.silva021.cartaodevisita.data.model.UserEntity
import com.silva021.cartaodevisita.databinding.FragmentHomeBinding
import com.silva021.cartaodevisita.domain.model.User
import com.silva021.cartaodevisita.ui.home.adapter.CardVisitAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    //    private val database: AppDatabase by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CardVisitApplication.database?.userDAO()?.getAll()?.forEach {
            Log.d("room", it.email)
        }
//        CardVisitApplication.database?.userDAO()?.insertUser(UserEntity(0,"Diego",
//                    "21 995999584",
//                    "diego@gmail.com",
//                    "Nasajon"))

        val adapter = CardVisitAdapter(
            listOf(
                User("Lucas",
                    "21 995999584",
                    "lucasssilva021@gmail.com",
                    "MovilePay"),
                User("Diego",
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