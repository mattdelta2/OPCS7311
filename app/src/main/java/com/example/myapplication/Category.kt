package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R.*

class Category : AppCompatActivity() {


    private lateinit var categoryEditText: EditText
    private lateinit var descriptionEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_category)


        categoryEditText = findViewById(R.id.categoryEditText)
        descriptionEditText = findViewById(R.id.descriptionEditText)


        val submitButton = findViewById<Button>(R.id.btnSubmit)


        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        submitButton.setOnClickListener()
            {

                val category = categoryEditText.text.toString()
                val description = descriptionEditText.text.toString()


                val editor = sharedPreferences.edit()



                editor.putString("Category", category)
                editor.putString("Description", description)



                editor.apply()



                categoryEditText.text.clear()
                descriptionEditText.text.clear()

            }


        var backButton = findViewById<Button>(R.id.btnBack)


        backButton.setOnClickListener()
        {
            val intent = Intent(this, MainMenu::class.java)

            startActivity(intent)
        }




        val savedCategory = sharedPreferences.getString("Category", " ")
        val savedDescription = sharedPreferences.getString("Description", " ")
    }
}