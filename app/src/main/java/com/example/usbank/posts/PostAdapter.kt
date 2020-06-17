package com.example.usbank.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usbank.R
import com.example.usbank.model.Post
import kotlinx.android.synthetic.main.adapter_post.view.*

class PostAdapter : RecyclerView.Adapter<PostViewHolder>(){

    lateinit var posts: ArrayList<Post>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindView(posts.get(position))
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setPost(iposts:ArrayList<Post>)
    {
        this.posts = iposts
    }
}

class PostViewHolder(itemview:View): RecyclerView.ViewHolder(itemview)
{
    fun bindView(post:Post)
    {

        itemView.title.text = post.title
        itemView.body.text = post.body
    }
}