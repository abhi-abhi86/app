# Retrofit
-keepattributes Signature
-keepattributes Exceptions
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# Data Classes (Keep generated components like copy, componentN, etc)
-keepclassmembers data class com.streampro.data.model.** {
    <fields>;
    <methods>;
}

# Hilt/Dagger
-keep class com.streampro.di.** { *; }
-keep class dagger.hilt.** { *; }
