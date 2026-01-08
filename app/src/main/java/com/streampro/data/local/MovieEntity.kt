package com.streampro.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: String,
    val title: String,
    val posterUrl: String,
    val cloudKey: String,
    val description: String?
)
