package com.silva021.cartaodevisita.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silva021.cartaodevisita.databinding.ItemCardVisitBinding
import com.silva021.cartaodevisita.domain.model.User

class CardVisitAdapter(private val list: List<User>) :
    RecyclerView.Adapter<CardVisitAdapter.CardVisitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardVisitViewHolder {
        return CardVisitViewHolder(
            ItemCardVisitBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: CardVisitViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    class CardVisitViewHolder(private val binding: ItemCardVisitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.textName.text = user.name
            binding.textEmail.text = user.email
            binding.textPhone.text = user.phone
            binding.textTitleCompany.text = user.enterprise
        }
    }
}