package com.streampro.presentation.features.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.TrackSelectionParameters
import androidx.media3.exoplayer.ExoPlayer
import com.streampro.common.Resource
import com.streampro.domain.usecase.GetSecureVideoUrlUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val getSecureVideoUrlUseCase: GetSecureVideoUrlUseCase,
    val player: ExoPlayer // Exposed for PlayerView
) : ViewModel() {

    private val _uiState = MutableStateFlow<PlayerUiState>(PlayerUiState.Idle)
    val uiState: StateFlow<PlayerUiState> = _uiState.asStateFlow()

    fun playVideo(cloudKey: String) {
        _uiState.value = PlayerUiState.Loading

        viewModelScope.launch {
            when (val result = getSecureVideoUrlUseCase(cloudKey)) {
                is Resource.Success -> {
                    result.data?.let { url ->
                        initializePlayer(url)
                        _uiState.value = PlayerUiState.Playing(url)
                    }
                }
                is Resource.Error -> {
                    _uiState.value = PlayerUiState.Error(result.message ?: "Unknown Error")
                }
                is Resource.Loading -> {
                     _uiState.value = PlayerUiState.Loading
                }
            }
        }
    }

    private fun initializePlayer(url: String) {
        val mediaItem = MediaItem.fromUri(url)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.playWhenReady = true
    }
    
    fun setQuality(quality: Quality) {
        val width = when(quality) {
             Quality.HIGH -> 1920
             Quality.MEDIUM -> 1280
             Quality.LOW -> 640
        }
        
        player.trackSelectionParameters = player.trackSelectionParameters
            .buildUpon()
            .setMaxVideoSize(width, width) // Rough approximation
            .build()
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }
}

sealed class PlayerUiState {
    object Idle : PlayerUiState()
    object Loading : PlayerUiState()
    data class Playing(val url: String) : PlayerUiState()
    data class Error(val message: String) : PlayerUiState()
}

enum class Quality { HIGH, MEDIUM, LOW }
