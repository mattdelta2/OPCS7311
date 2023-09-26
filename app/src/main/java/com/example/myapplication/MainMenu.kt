package com.example.myapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)



        val timerButton = findViewById<ImageButton>(R.id.btnTimer)

        timerButton.setOnClickListener()
        {
            val intent = Intent(this, Timer::class.java)
            startActivity(intent)
        }

        val listButton = findViewById<ImageButton>(R.id.btnList )

        listButton.setOnClickListener()
        {
            val intent = Intent(this, AllWork::class.java)

            startActivity(intent)
        }

        val roomButton = findViewById<ImageButton>(R.id.btnRoom )

        roomButton.setOnClickListener()
        {
            val intent = Intent(this, PlayerRoom::class.java)

            startActivity(intent)
        }

        val shopButton = findViewById<ImageButton>(R.id.btnShop )

        shopButton.setOnClickListener()
        {
            val intent = Intent(this, Shop::class.java)

            startActivity(intent)
        }

        val categoryButton = findViewById<ImageButton>(R.id.btnCategory )

        categoryButton.setOnClickListener()
        {
            val intent = Intent(this, Category::class.java)

            startActivity(intent)
        }

        val dateButton = findViewById<ImageButton>(R.id.btnDate )

        listButton.setOnClickListener()
        {
            val intent = Intent(this, Date::class.java)

            startActivity(intent)
        }





    }
}