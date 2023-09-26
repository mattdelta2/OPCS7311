package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)



        val timerButton = findViewById<ImageButton>(R.id.imageButton)

        timerButton.setOnClickListener()
        {
            val intent = Intent(this, Timer::class.java)

            startActivity(intent)
        }



    }
}