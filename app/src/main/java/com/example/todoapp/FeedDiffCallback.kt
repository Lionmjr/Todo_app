package com.example.todoapp

import androidx.recyclerview.widget.DiffUtil

// FeedDiffCallback.kt
class FeedDiffCallback : DiffUtil.ItemCallback<FeedItem>() {
    override fun areItemsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean {
        return oldItem == newItem
    }
}