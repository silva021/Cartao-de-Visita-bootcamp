package com.silva021.cartaodevisita.utils.extension

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout

fun Fragment.clearFields(vararg editText: TextInputLayout) {
    editText.forEach {
        it.editText?.text?.clear()
    }
}

fun Fragment.validateField(vararg textInputLayout: TextInputLayout): Boolean {
    var isValidate = true
    textInputLayout.forEach {
        if (it.validateField())
            isValidate = false
    }
    return isValidate
}

fun Fragment.finish() {
    requireActivity().onBackPressed()
}

fun Fragment.hideKeyboard() {
    val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view?.windowToken, 0)
}