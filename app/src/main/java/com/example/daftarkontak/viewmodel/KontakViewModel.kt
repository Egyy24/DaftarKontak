package com.example.daftarkontak.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daftarkontak.data.local.KontakEntity
import com.example.daftarkontak.data.repository.KontakRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class KontakViewModel(private val repo: KontakRepository) : ViewModel() {

    val daftarKontak = repo.semuaKontak

    var nama = MutableStateFlow("")
    var nomorTelepon = MutableStateFlow("")
    var alamat = MutableStateFlow("")

    fun simpanKontak() {
        if (nama.value.isNotBlank() && nomorTelepon.value.isNotBlank()) {
            viewModelScope.launch {
                repo.tambahKontak(
                    KontakEntity(
                        nama = nama.value,
                        nomorTelepon = nomorTelepon.value,
                        alamat = alamat.value
                    )
                )

                // clear input
                nama.value = ""
                nomorTelepon.value = ""
                alamat.value = ""
            }
        }
    }
}


