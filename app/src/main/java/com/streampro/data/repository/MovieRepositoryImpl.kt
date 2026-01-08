package com.streampro.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.streampro.common.ApiError
import com.streampro.common.NetworkError
import com.streampro.common.Resource
import com.streampro.data.api.ApiService
import com.streampro.data.datasource.MoviePagingSource
import com.streampro.data.mapper.toDomain
import com.streampro.domain.model.Movie
import com.streampro.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val database: com.streampro.data.local.AppDatabase
) : MovieRepository {

    @OptIn(androidx.paging.ExperimentalPagingApi::class)
    override fun getMoviesStream(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            remoteMediator = com.streampro.data.datasource.MovieRemoteMediator(database, apiService),
            pagingSourceFactory = { database.movieDao().getMovies() }
        ).flow.map { pagingData ->
            pagingData.map { it.toDomain() }
        }
    }

    override suspend fun getSecureVideoUrl(key: String): Resource<String> {
        return try {
            val response = apiService.getSecureLink(key)
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!.streamUrl)
            } else {
                Resource.Error("API Error: ${response.code()}")
            }
        } catch (e: IOException) {
            Resource.Error("Network Error: ${e.message}")
        } catch (e: Exception) {
            Resource.Error("Unknown Error: ${e.message}")
        }
    }
}
