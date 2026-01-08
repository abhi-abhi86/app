package com.streampro.domain.usecase

import androidx.paging.PagingData
import com.streampro.domain.model.Movie
import com.streampro.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.getMoviesStream()
    }
}
