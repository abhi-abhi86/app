package com.streampro.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeys(
    @PrimaryKey val movieId: String,
    val prevKey: Int?,
    val nextKey: Int?
)
