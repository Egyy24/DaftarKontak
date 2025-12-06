package com.example.daftarkontak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.daftarkontak.data.local.KontakDatabase
import com.example.daftarkontak.data.repository.KontakRepository
import com.example.daftarkontak.ui.halaman.HalamanKontak
import com.example.daftarkontak.viewmodel.KontakViewModel
import com.example.daftarkontak.viewmodel.KontakViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            KontakDatabase::class.java,
            "db_kontak"
        ).build()

        val repo = KontakRepository(db.kontakDao())
        val factory = KontakViewModelFactory(repo)

        setContent {
            val vm: KontakViewModel = viewModel(factory = factory)

            HalamanKontak(vm)
        }
    }
}
