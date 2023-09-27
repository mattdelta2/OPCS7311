package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class AllWork : AppCompatActivity() {

    // In your getSavedTimesheetEntries function
    private fun getSavedTimesheetEntries(): List<TimesheetEntry> {
        val gson = Gson()
        val sharedPreferences = getSharedPreferences("TimesheetEntries", Context.MODE_PRIVATE)
        val entriesSet =
            sharedPreferences.getStringSet("timesheet_entries", mutableSetOf()) ?: mutableSetOf()

        // Convert the set of JSON strings back to a list of TimesheetEntry objects

        return entriesSet.mapNotNull { gson.fromJson(it, TimesheetEntry::class.java) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_work)

        val entriesRecyclerView = findViewById<RecyclerView>(R.id.entriesRecyclerView)

        // Retrieve the saved timesheet entries
        val timesheetEntries = getSavedTimesheetEntries()

        // Initialize and set the adapter for the RecyclerView
        val adapter = TimesheetEntryAdapter(timesheetEntries)
        entriesRecyclerView.adapter = adapter
    }
}