package com.example.daftarkontak.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabel_kontak")
data class KontakEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val nomorTelepon: String,
    val alamat: String
)
