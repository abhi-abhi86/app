package com.streampro.data.model

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("poster_url") val posterUrl: String,
    @SerializedName("cloud_key") val cloudKey: String,
    @SerializedName("description") val description: String? = null
)

data class CloudTokenDto(
    @SerializedName("stream_url") val streamUrl: String,
    @SerializedName("expires_at") val expiresAt: Long
)
