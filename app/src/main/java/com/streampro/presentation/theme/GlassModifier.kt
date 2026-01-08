package com.streampro.presentation.theme

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

fun Modifier.glassEffect(): Modifier {
    val shape = RoundedCornerShape(24.dp)
    
    return this
        .graphicsLayer {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                renderEffect = RenderEffect
                    .createBlurEffect(
                        30f, 
                        30f, 
                        Shader.TileMode.MIRROR
                    ).asComposeRenderEffect()
            }
            alpha = 0.9f 
        }
        .background(
            color = Color.White.copy(alpha = 0.05f),
            shape = shape
        )
        .border(
            width = 1.dp,
            color = Color.White.copy(alpha = 0.2f),
            shape = shape
        )
        .clip(shape)
}
