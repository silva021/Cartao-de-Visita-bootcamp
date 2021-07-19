package com.silva021.cartaodevisita.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silva021.cartaodevisita.databinding.ItemCardVisitBinding
import com.silva021.cartaodevisita.domain.model.People

class CardVisitAdapter(private val list: List<People>) :
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
        fun bind(people: People) {
            binding.textName.text = people.name
            binding.textEmail.text = people.email
            binding.textPhone.text = people.phone
            binding.textTitleCompany.text = people.enterprise
        }
    }
}