package com.silva021.cartaodevisita.utils.extension

import android.widget.EditText

fun EditText.validateField(): Boolean {
    return this.text.toString().isNotEmpty()
}

