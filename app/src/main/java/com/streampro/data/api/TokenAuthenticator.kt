package com.streampro.data.api

import com.streampro.data.local.TokenManager
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject
import javax.inject.Provider

class TokenAuthenticator @Inject constructor(
    private val tokenManager: TokenManager,
    // Use Provider to avoid circular dependency with ApiService
    private val apiServiceProvider: Provider<ApiService> 
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        // If the request already failed with the new token, give up to avoid infinite loop
        if (responseCount(response) >= 3) {
            return null
        }

        return runBlocking {
            val newToken = refreshToken()
            if (newToken != null) {
                tokenManager.saveToken(newToken)
                response.request.newBuilder()
                    .header("Authorization", "Bearer $newToken")
                    .build()
            } else {
                null
            }
        }
    }

    private suspend fun refreshToken(): String? {
        // Mock implementation since we don't have a real refresh endpoint yet
        // In a real app, call apiServiceProvider.get().refreshToken()
        return try {
             // val refreshResponse = apiServiceProvider.get().refreshToken()
             // if (refreshResponse.isSuccessful) refreshResponse.body()?.token else null
             "mock_refreshed_token" 
        } catch (e: Exception) {
            null
        }
    }
    private fun responseCount(response: Response): Int {
        var result = 1
        var prior = response.priorResponse
        while (prior != null) {
            result++
            prior = prior.priorResponse
        }
        return result
    }
}
