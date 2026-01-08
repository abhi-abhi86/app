package com.streampro.presentation.theme

import android.graphics.RuntimeShader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import kotlinx.coroutines.delay

@Composable
fun FluidBackground() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        AnimatedFluidShader()
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF000510)) // Fallback dark blue
        )
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun AnimatedFluidShader() {
    val shader = remember { RuntimeShader(WATER_SHADER) }
    var time by remember { mutableStateOf(0f) }
    
    LaunchedEffect(Unit) {
        val startTime = System.nanoTime()
        while (true) {
            time = (System.nanoTime() - startTime) / 1_000_000_000f
            delay(16) // ~60 FPS
        }
    }
    
    Canvas(modifier = Modifier.fillMaxSize()) {
        shader.setFloatUniform("resolution", size.width, size.height)
        shader.setFloatUniform("time", time)
        drawRect(brush = ShaderBrush(shader))
    }
}
