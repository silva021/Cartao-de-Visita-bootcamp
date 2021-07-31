package com.silva021.cartaodevisita.utils.extension

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.validateField(): Boolean {
    if (this.editText?.text.toString().isEmpty()) {
        this.error = "Esse campo tem que ser preenchido"
        this.isFocusable = true
    } else
        this.error = ""
    this.isErrorEnabled = this.editText?.text.toString().isEmpty()
    return this.isErrorEnabled
}