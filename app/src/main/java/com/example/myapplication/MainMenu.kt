package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)



        val timerButton = findViewById<Button>(R.id.btnTimer)

        timerButton.setOnClickListener()
        {
            val intent = Intent(this, Timer::class.java)
        }



    }
}