package com.streampro.data.api

import com.streampro.data.model.CloudTokenDto
import com.streampro.data.model.MovieDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movies")
    suspend fun getMovies(@Query("page") page: Int): Response<List<MovieDto>>

    @GET("secure/link")
    suspend fun getSecureLink(@Query("key") cloudKey: String): Response<CloudTokenDto>
}
