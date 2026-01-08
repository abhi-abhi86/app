package com.streampro.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.streampro.data.local.MovieEntity
import com.streampro.data.local.RemoteKeys

@Database(entities = [MovieEntity::class, RemoteKeys::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}
