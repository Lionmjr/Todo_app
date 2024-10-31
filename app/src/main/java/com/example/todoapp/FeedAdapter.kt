package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

// FeedAdapter.kt
class FeedAdapter : ListAdapter<FeedItem, FeedAdapter.FeedViewHolder>(FeedDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleText: TextView = view.findViewById(R.id.feed_title)
        private val locationText: TextView = view.findViewById(R.id.feed_location)
        private val timeText: TextView = view.findViewById(R.id.feed_time)

        fun bind(feedItem: FeedItem) {
            titleText.text = feedItem.title
            locationText.text = feedItem.location
            timeText.text = feedItem.time
        }
    }

    // No need to define submitList here
}
