package uz.polat.mockapi2

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.polat.mockapi2.retrofit.ApiClient
import uz.polat.mockapi2.retrofit.Post

class MainVM : ViewModel() {

    private val postApi = ApiClient.postApi

    var post: MutableState<Post?> = mutableStateOf(null)
    var toast = mutableStateOf("")

    fun getPost1() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = postApi.getPost1()
            if (response.isSuccessful && response.body() != null) {
                post.value = response.body()!!
            } else if (response.errorBody() != null) {
                toast.value = response.errorBody()!!.string()
            } else {
                toast.value = "Unknown error"
            }
        }
    }

    fun getPost2() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = postApi.getPost2()
            if (response.isSuccessful && response.body() != null) {
                post.value = response.body()!!
            } else if (response.errorBody() != null) {
                toast.value = response.errorBody()!!.string()
            } else {
                toast.value = "Unknown error"
            }
        }
    }

    fun getPost3() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = postApi.getPost3()
            if (response.isSuccessful && response.body() != null) {
                post.value = response.body()!!
            } else if (response.errorBody() != null) {
                toast.value = response.errorBody()!!.string()
            } else {
                toast.value = "Unknown error"
            }
        }
    }

}