package com.silva021.cartaodevisita.utils.extension

import android.widget.EditText
import androidx.fragment.app.Fragment

fun Fragment.clearFields(vararg editText: EditText) {
    editText.forEach {
        it.text.clear()
    }
}

fun Fragment.finish() {
    requireActivity().onBackPressed()
}
