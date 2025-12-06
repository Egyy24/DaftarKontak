package com.example.daftarkontak.data.repository

import com.example.daftarkontak.data.local.KontakDao
import com.example.daftarkontak.data.local.KontakEntity

class KontakRepository(private val dao: KontakDao) {

    val semuaKontak = dao.getSemuaKontak()

    suspend fun tambahKontak(kontak: KontakEntity) {
        dao.insertKontak(kontak)
    }
}


