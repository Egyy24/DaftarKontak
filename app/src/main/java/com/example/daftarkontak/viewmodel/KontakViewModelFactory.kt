package com.example.daftarkontak.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daftarkontak.data.repository.KontakRepository

class KontakViewModelFactory(private val repo: KontakRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return KontakViewModel(repo) as T
    }
}
