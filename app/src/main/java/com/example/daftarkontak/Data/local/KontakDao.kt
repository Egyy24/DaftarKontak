package com.example.daftarkontak.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface KontakDao {

    @Query("SELECT * FROM tabel_kontak ORDER BY id DESC")
    fun getSemuaKontak(): Flow<List<KontakEntity>>

    @Insert
    suspend fun insertKontak(kontak: KontakEntity)
}


