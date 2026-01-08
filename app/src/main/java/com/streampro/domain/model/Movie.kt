package com.streampro.domain.model

data class Movie(
    val id: String,
    val title: String,
    val posterUrl: String,
    val cloudKey: String,
    val description: String? = null
)
