package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class CategoryName(val id: Int, val name: String) {

}

data class TimesheetEntry(
    val date: String,
    val startTime: String,
    val endTime: String,
    val description: String,
    val category: String
)

class MainActivity : AppCompatActivity() {

    private lateinit var categoryManager: CategoryManager
    private lateinit var categoryContainer: LinearLayout
    private lateinit var addCategoryButton: Button
    private lateinit var categoryNameEditText: EditText
    private lateinit var entryDateEditText: EditText
    private lateinit var startTimeEditText: EditText
    private lateinit var endTimeEditText : EditText
    private lateinit var descriptionEditText: EditText
    private val SELECT_IMAGE_REQUEST_CODE = 1001

    private lateinit var backButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoryManager = CategoryManager(applicationContext)
        categoryContainer = findViewById(R.id.categoryContainer)
        addCategoryButton = findViewById(R.id.addCategoryButton)
        categoryNameEditText = findViewById(R.id.categoryNameEditText)
        backButton = findViewById(R.id.btnBack)

        // In onCreate method
        val categoryImageView = findViewById<ImageView>(R.id.userImage)
        val categorySpinner = findViewById<Spinner>(R.id.categorySpinner)
        val categories = categoryManager.getCategories().map { it.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter


        addCategoryButton.setOnClickListener {
            val date = entryDateEditText.text.toString()
            val startTime = startTimeEditText.text.toString()
            val endTime = endTimeEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val selectedCategory = categorySpinner.selectedItem.toString()
            val userImage = categoryManager.selectImageForCategory(this, SELECT_IMAGE_REQUEST_CODE)

            if (date.isNotEmpty() && startTime.isNotEmpty() && endTime.isNotEmpty() && description.isNotEmpty()) {
                val timesheetEntry = TimesheetEntry(date, startTime, endTime, description, selectedCategory)

                // Call a function to save the timesheet entry
                saveTimesheetEntry(timesheetEntry)

                // Clear the input fields or perform any other desired actions
                entryDateEditText.text.clear()
                startTimeEditText.text.clear()
                endTimeEditText.text.clear()
                descriptionEditText.text.clear()

            }
        }
        backButton.setOnClickListener()
        {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun saveTimesheetEntry(entry: TimesheetEntry) {
        // Retrieve the existing list of saved entries from shared preferences
        val gson = Gson()
        val existingEntries = getSavedTimesheetEntries()

        // Add the new entry to the list
        existingEntries.add(gson.toJson(entry))

        // Convert the updated list back to a set
        val updatedEntriesSet = existingEntries.map { gson.toJson(entry) }.toSet()

        // Save the updated set of entries to shared preferences
        val sharedPreferences = getSharedPreferences("TimesheetEntries", Context.MODE_PRIVATE)
        sharedPreferences.edit().putStringSet("timesheet_entries", updatedEntriesSet).apply()
    }

    private fun getSavedTimesheetEntries(): MutableSet<String> {
        // Retrieve the list of saved entries from shared preferences
        val sharedPreferences = getSharedPreferences("TimesheetEntries", Context.MODE_PRIVATE)
        return sharedPreferences.getStringSet("timesheet_entries", mutableSetOf()) ?: mutableSetOf()
    }

    private fun createCategoryTextView(categoryName: String) {
        val newCategoryTextView = TextView(this)
        newCategoryTextView.text = categoryName
        newCategoryTextView.textSize = 16f
        newCategoryTextView.setPadding(8, 8, 8, 8)

        newCategoryTextView.setOnClickListener {
            val categoryName = newCategoryTextView.text.toString()
            val categoryToRemove = categoryManager.getCategories().find { it.name == categoryName }

            if (categoryToRemove != null) {
                categoryManager.removeCategory(categoryToRemove)
                categoryContainer.removeView(newCategoryTextView)
            }
        }

        categoryContainer.addView(newCategoryTextView)
    }
}


