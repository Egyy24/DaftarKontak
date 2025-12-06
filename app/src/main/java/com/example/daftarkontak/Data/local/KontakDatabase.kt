package com.example.daftarkontak.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [KontakEntity::class],
    version = 1,
    exportSchema = false
)
abstract class KontakDatabase : RoomDatabase() {
    abstract fun kontakDao(): KontakDao
}
