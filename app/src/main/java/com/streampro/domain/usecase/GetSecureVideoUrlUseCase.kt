package com.streampro.domain.usecase

import com.streampro.common.Resource
import com.streampro.domain.repository.MovieRepository
import javax.inject.Inject

class GetSecureVideoUrlUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(cloudKey: String): Resource<String> {
        return repository.getSecureVideoUrl(cloudKey)
    }
}
