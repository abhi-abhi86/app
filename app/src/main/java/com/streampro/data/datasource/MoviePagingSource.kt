package com.streampro.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.streampro.data.api.ApiService
import com.streampro.data.mapper.toDomain
import com.streampro.domain.model.Movie
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource(
    private val apiService: ApiService
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val position = params.key ?: 1
        return try {
            val response = apiService.getMovies(page = position)
            val body = response.body()
            
            if (response.isSuccessful && body != null) {
                val movies = body.map { it.toDomain() }
                val nextKey = if (movies.isEmpty()) null else position + 1
                LoadResult.Page(
                    data = movies,
                    prevKey = if (position == 1) null else position - 1,
                    nextKey = nextKey
                )
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
