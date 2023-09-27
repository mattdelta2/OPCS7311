package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TimesheetEntryAdapter(private val entries: List<TimesheetEntry>) :
    RecyclerView.Adapter<TimesheetEntryAdapter.EntryViewHolder>() {

    class EntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_all_work, parent, false)
        return EntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = entries[position]
        // Bind entry data to the UI elements in the entry_item layout
        // You can display date, start time, end time, description, category, and more.
    }

    override fun getItemCount() = entries.size
}

