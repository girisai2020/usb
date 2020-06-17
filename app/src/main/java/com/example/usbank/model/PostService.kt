package com.example.usbank.model

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun listPosts(): Call<List<Post>>

}