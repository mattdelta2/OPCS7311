package com.example.myapplication

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts

class CategoryManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("Categories", Context.MODE_PRIVATE)
    private val gson = Gson()
    private var categoryCounter = 1 // Counter for generating unique IDs
    private val getImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        // Handle the selected image URI here
        // You can save it or use it as needed
    }

    // Function to generate a unique ID
    fun generateUniqueId(): Int {
        return categoryCounter++
    }

    fun addCategory(category: CategoryName) {
        val categories = getCategories().toMutableList()
        categories.add(category)
        saveCategories(categories)
    }

    fun removeCategory(category: CategoryName) {
        val categories = getCategories().toMutableList()
        categories.remove(category)
        saveCategories(categories)
    }

    fun getCategories(): List<CategoryName> {
        val json = sharedPreferences.getString("categories", "[]")
        return gson.fromJson(json, object : TypeToken<List<CategoryName>>() {}.type)
    }

    private fun saveCategories(categories: List<CategoryName>) {
        val json = gson.toJson(categories)
        sharedPreferences.edit().putString("categories", json).apply()
    }

    // Function to trigger image selection
    fun chooseImageFromGallery(activity: Activity) {
        getImage.launch("image/*")
    }
}
