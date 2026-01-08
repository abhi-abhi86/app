package com.streampro.data.mapper

import com.streampro.data.local.MovieEntity
import com.streampro.data.model.MovieDto
import com.streampro.domain.model.Movie

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        posterUrl = posterUrl,
        cloudKey = cloudKey,
        description = description
    )
}

fun MovieDto.toEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        posterUrl = posterUrl,
        cloudKey = cloudKey,
        description = description
    )
}

fun MovieEntity.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        posterUrl = posterUrl,
        cloudKey = cloudKey,
        description = description
    )
}
