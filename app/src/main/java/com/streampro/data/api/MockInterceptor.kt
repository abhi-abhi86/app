package com.streampro.data.api

import com.streampro.data.model.CloudTokenDto
import com.streampro.data.model.MovieDto
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import javax.inject.Inject

class MockInterceptor @Inject constructor() : Interceptor {
    private val gson = Gson()

    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url.toUri()
        val path = uri.path

        return when {
            path.endsWith("movies") -> {
                val mockMovies = listOf(
                    MovieDto(
                        id = "1",
                        title = "Big Buck Bunny",
                        posterUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
                        cloudKey = "bbb",
                        description = "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself. When one sunny day three rodents rudely harass him, something snaps... and the bunny ain't no bunny anymore! In the typical cartoon tradition he prepares the nasty rodents a comical revenge."
                    ),
                    MovieDto(
                        id = "2",
                        title = "Elephant Dream",
                        posterUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg",
                        cloudKey = "ed",
                        description = "The first Blender Open Movie from 2006."
                    ),
                     MovieDto(
                        id = "3",
                        title = "For Bigger Blazes",
                        posterUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg",
                        cloudKey = "fbb",
                        description = "HBO GO now works with Chromecast -- the easiest way to enjoy online video on your TV. For when you want to settle into your Iron Throne to watch the latest episodes. For \$35.\nLearn how to use Chromecast with HBO GO and more at google.com/chromecast."
                    )
                )
                
                val json = gson.toJson(mockMovies)
                makeResponse(chain.request(), json)
            }
            path.contains("secure/link") -> {
                // Return Big Buck Bunny URL for all keys for testing
                val mockToken = CloudTokenDto(
                    streamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                    expiresAt = System.currentTimeMillis() + 3600000
                )
                val json = gson.toJson(mockToken)
                makeResponse(chain.request(), json)
            }
            else -> chain.proceed(chain.request())
        }
    }

    private fun makeResponse(request: Request, json: String): Response {
        return Response.Builder()
            .code(200)
            .message("OK")
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .body(json.toResponseBody("application/json".toMediaType()))
            .build()
    }
}
