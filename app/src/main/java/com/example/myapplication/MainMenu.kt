package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.widget.Button
import android.widget.ImageButton
=======
>>>>>>> parent of 66d9c21 (adding a timer)

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
<<<<<<< HEAD



        val timerButton = findViewById<ImageButton>(R.id.imageButton)

        timerButton.setOnClickListener()
        {
            val intent = Intent(this, Timer::class.java)

            startActivity(intent)
        }



=======
>>>>>>> parent of 66d9c21 (adding a timer)
    }
}