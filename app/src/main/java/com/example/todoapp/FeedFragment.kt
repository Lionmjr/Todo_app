// FeedFragment.kt
package com.example.todoapp

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.FeedFragment.Companion.ARG_COLUMN_COUNT
import com.example.todoapp.placeholder.PlaceholderContent

class FeedFragment : Fragment() {
    private lateinit var feedAdapter: FeedAdapter
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed_list, container, false)
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = feedAdapter
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerForContextMenu(view.findViewById(R.id.feed_recycler_view))

        // Initialize RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.feed_recycler_view)
        feedAdapter = FeedAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = feedAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        // Load feed items
        loadFeedItems()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        requireActivity().menuInflater.inflate(R.menu.context_menu, menu)
    }

    private fun loadFeedItems() {
        // Example feed items
        val feedItems = listOf(
            FeedItem("Study Group Meeting", "Library Room 204", "2:00 PM"),
            FeedItem("Project Deadline", "Submit on Canvas", "11:59 PM"),
            FeedItem("Club Meeting", "Student Center", "4:00 PM")  // Fixed syntax
        )
        feedAdapter.submitList(feedItems)  // Call on instance, not class
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            FeedFragment().apply {
                var arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}



