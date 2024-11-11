package uz.polat.mockapi2.app

import android.app.Application
import android.content.Context
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import uz.polat.mockapi2.retrofit.ApiClient
import java.util.concurrent.TimeUnit

class App:Application() {
    lateinit var mockWebServer: MockWebServer


    companion object{
        lateinit var context:Context
        lateinit var baseUrl:String
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        CoroutineScope(Dispatchers.IO).launch {
            mockWebServer = MockWebServer()
            mockWebServer.start()

            // Step 2: Set the base URL to MockWebServer’s URL
//            ApiClient.setBaseUrl(mockWebServer.url("/").toString())
            baseUrl = mockWebServer.url("/").toString()
            Log.d("TAG", "onCreate: baseurl: $baseUrl")

            mockWebServer.dispatcher = object : Dispatcher() {
                override fun dispatch(request: RecordedRequest): MockResponse {
                    return when (request.path) {
                        "/posts/1" -> MockResponse()
                            .setResponseCode(200)
                            .setBody("""
                                {
                                    "userId": 1,
                                    "id": 1,
                                    "title": "Post 1 Title",
                                    "body": "Content of post 1."
                                }
                            """.trimIndent())
                            .throttleBody(50,1,TimeUnit.SECONDS)

                        "/posts/2" -> MockResponse()
                            .setResponseCode(200)
                            .setBody("""
                                {
                                    "userId": 1,
                                    "id": 2,
                                    "title": "Post 2 Title",
                                    "body": "Content of post 2."
                                }
                            """.trimIndent())

                        "/posts/3" -> MockResponse()
                            .setResponseCode(200)
                            .setBody("""
                                 {
                                    "userId": 3,
                                    "id": 3,
                                    "title": "Post 3 Title",
                                    "body": "Content of post 3."
                                }
                            """.trimIndent())

                        else -> MockResponse().setResponseCode(404).setBody("jonga tegding xatooooo")
                    }
                }
            }

        }

    }

    override fun onTerminate() {
        super.onTerminate()
        // Shutdown the server when the app is terminated
        mockWebServer.shutdown()
    }
}