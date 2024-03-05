package com.example.restaurantsearcher.ui.viewmodel

import androidx.lifecycle.ViewModel

class InputKeyWordViewModel : ViewModel() {
    // 入力されたキーワードが空でないかを判定する
    fun isInputNotEmpty(inputText: String): Boolean {
        return inputText.isNotEmpty()
    }
}