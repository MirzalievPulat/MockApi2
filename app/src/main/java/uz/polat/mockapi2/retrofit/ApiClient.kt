package uz.polat.mockapi2.retrofit

import com.chuckerteam.chucker.api.ChuckerInterceptor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.polat.mockapi2.app.App
import uz.polat.mockapi2.app.App.Companion.baseUrl

object ApiClient {

//    private var baseUrl = "https://jsonplaceholder.typicode.com/"


    val myOkHttpClient = OkHttpClient.Builder().addInterceptor(ChuckerInterceptor.Builder(App.context).build()).build()

//    val retrofit by lazy {
//        Retrofit.Builder().baseUrl(baseUrl).client(myOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
//    }
    val retrofit = Retrofit.Builder().baseUrl(baseUrl).client(myOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build()


//    val postApi by lazy { retrofit.create(PostApi::class.java)}
    val postApi = retrofit.create(PostApi::class.java)
}








