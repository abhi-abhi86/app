package com.streampro.presentation.theme

import org.intellij.lang.annotations.Language

@Language("AGSL")
val WATER_SHADER = """
    uniform float2 resolution;
    uniform float time;
    
    // Simplex noise function
    vec3 hash3(vec2 p) {
        vec3 q = vec3(dot(p, vec2(127.1, 311.7)), dot(p, vec2(269.5, 183.3)), dot(p, vec2(419.2, 371.9)));
        return fract(sin(q) * 43758.5453);
    }
    
    float noise(vec2 x) {
        vec2 p = floor(x);
        vec2 f = fract(x);
        f = f * f * (3.0 - 2.0 * f);
        return mix(mix(dot(hash3(p + vec2(0.0, 0.0)).xy, f - vec2(0.0, 0.0)),
                       dot(hash3(p + vec2(1.0, 0.0)).xy, f - vec2(1.0, 0.0)), f.x),
                   mix(dot(hash3(p + vec2(0.0, 1.0)).xy, f - vec2(0.0, 1.0)),
                       dot(hash3(p + vec2(1.0, 1.0)).xy, f - vec2(1.0, 1.0)), f.x), f.y);
    }

    half4 main(float2 fragCoord) {
        float2 uv = fragCoord.xy / resolution.xy;
        
        // Liquid Distortion
        float t = time * 0.5;
        vec2 p = -1.0 + 2.0 * uv;
        float len = length(p);
        vec2 uv_dis = uv + (p/len) * cos(len * 12.0 - time * 4.0) * 0.03;
        
        // Color Mix
        vec3 colorA = vec3(0.0, 0.2, 0.5); // Deep Blue
        vec3 colorB = vec3(0.0, 0.0, 0.1); // Dark Void
        
        float n = noise(uv_dis * 3.0 + time);
        vec3 finalColor = mix(colorA, colorB, n + uv.y);
        
        // Vignette
        float vignette = smoothstep(1.5, 0.5, len);
        
        return half4(finalColor * vignette, 1.0);
    }
""".trimIndent()
