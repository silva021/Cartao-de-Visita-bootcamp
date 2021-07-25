package com.silva021.cartaodevisita.domain.model

data class User(
    val id: Int,
    val name: String,
    val phone: String?,
    val email: String,
    val enterprise: String,
)