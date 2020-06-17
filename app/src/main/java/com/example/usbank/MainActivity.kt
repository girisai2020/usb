package com.example.usbank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usbank.model.Post
import kotlin.collections.ArrayList
import androidx.lifecycle.Observer
import com.example.usbank.posts.PostAdapter
import com.example.usbank.posts.PostViewModel

class MainActivity : AppCompatActivity() {

    //this is to see change in dev branch

    val viewModel: PostViewModel by viewModels()

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        viewModel.getPosts().observe(this, Observer {
            setRecycler(it as ArrayList<Post>)
        })
    }

    fun setRecycler(posts:ArrayList<Post>)
    {
        var adapter: PostAdapter = PostAdapter()
        adapter.posts = posts

        recyclerView.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }
}
