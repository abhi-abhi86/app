package com.streampro.domain.repository

import androidx.paging.PagingData
import com.streampro.common.Resource
import com.streampro.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMoviesStream(): Flow<PagingData<Movie>>
    suspend fun getSecureVideoUrl(key: String): Resource<String>
}
