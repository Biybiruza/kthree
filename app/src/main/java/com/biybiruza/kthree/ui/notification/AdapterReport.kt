package com.biybiruza.kthree.ui.notification

import android.media.RouteListingPreference.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.biybiruza.kthree.R
import com.biybiruza.kthree.data.Post
import com.biybiruza.kthree.databinding.ItemPostBinding

class AdapterReport : RecyclerView.Adapter<AdapterReport.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemPostBinding.bind(itemView)
        fun popularModel(post: Post){
            binding.tvLocation.text = post.location
            binding.tvDescription.text = post.description
        }
    }

    var postList = listOf<Post>()
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.popularModel(postList[position])
    }
}