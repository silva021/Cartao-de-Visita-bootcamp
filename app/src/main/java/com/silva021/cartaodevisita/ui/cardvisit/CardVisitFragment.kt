package com.silva021.cartaodevisita.ui.cardvisit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.silva021.cartaodevisita.databinding.FragmentCardVisitBinding
import com.silva021.cartaodevisita.domain.model.User
import com.silva021.cartaodevisita.utils.extension.clearFields
import com.silva021.cartaodevisita.utils.extension.finish
import com.silva021.cartaodevisita.utils.extension.validateField
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CardVisitFragment : Fragment() {
    private lateinit var binding: FragmentCardVisitBinding
    private val cardVisitViewModel: CardVisitViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCardVisitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupListener()
    }

    private fun validateFields(): Boolean {
        with(binding) {
            return editEmail.validateField() && editName.validateField() && editEnterprise.validateField()
        }
    }

    private fun addCardVisit() {
        cardVisitViewModel.insertNewCardVisit(returnUser())
    }

    private fun returnUser(): User {
        with(binding) {
            return User(
                id = 0,
                name = editName.text.toString(),
                phone = editNumberPhone.text.toString(),
                email = editEmail.text.toString(),
                enterprise = editEnterprise.text.toString())
        }
    }

    private fun setupListener() {
        binding.buttonAddCardVisit.setOnClickListener {
            if (validateFields()) {
                addCardVisit()
            }
        }

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupObserver() {
        cardVisitViewModel.response.observe(viewLifecycleOwner, {
            if (it) {
                with(binding) {
                    clearFields(editEmail, editEnterprise, editName, editNumberPhone)
                    Snackbar.make(root, "Novo cartão adicionado!", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }
}