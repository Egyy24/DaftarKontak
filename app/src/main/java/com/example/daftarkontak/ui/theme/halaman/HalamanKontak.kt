package com.example.daftarkontak.ui.halaman

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.daftarkontak.viewmodel.KontakViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanKontak(vm: KontakViewModel) {

    val daftarKontak by vm.daftarKontak.collectAsState(initial = emptyList())
    val nama by vm.nama.collectAsState()
    val nomor by vm.nomorTelepon.collectAsState()
    val alamat by vm.alamat.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Daftar Kontak") })
        }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {

            OutlinedTextField(
                value = nama,
                onValueChange = { vm.nama.value = it },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = nomor,
                onValueChange = { vm.nomorTelepon.value = it },
                label = { Text("Nomor Telepon") },
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            )

            OutlinedTextField(
                value = alamat,
                onValueChange = { vm.alamat.value = it },
                label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            )

            Button(
                onClick = { vm.simpanKontak() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Simpan Kontak")
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                items(daftarKontak) { kontak ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(Modifier.padding(12.dp)) {
                            Text("Nama: ${kontak.nama}")
                            Text("Nomor: ${kontak.nomorTelepon}")
                            Text("Alamat: ${kontak.alamat}")
                        }
                    }
                }
            }
        }
    }
}




