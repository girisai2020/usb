package com.example.usbank.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usbank.model.APIService
import com.example.usbank.model.Post
import com.example.usbank.model.PostService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {

    private lateinit var posts: MutableLiveData<List<Post>>

    init {
        posts  = MutableLiveData<List<Post>>()
        callPosts()
    }

    fun getPosts(): LiveData<List<Post>>
    {
        return posts
    }

    fun callPosts()
    {
        println("service call posts is called")
        val request = APIService.buildService(PostService::class.java)
        val call = request.listPosts()

        call.enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                posts.value = response.body()
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                println("failure retrofit "+t.message)
            }
        })
    }

}