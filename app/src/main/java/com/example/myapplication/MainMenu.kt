package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.widget.Button
import android.widget.ImageButton
=======
>>>>>>> parent of 66d9c21 (adding a timer)
=======
>>>>>>> parent of 66d9c21 (adding a timer)
=======
>>>>>>> parent of 66d9c21 (adding a timer)

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD



        val timerButton = findViewById<ImageButton>(R.id.imageButton)

        timerButton.setOnClickListener()
        {
            val intent = Intent(this, Timer::class.java)

            startActivity(intent)
<<<<<<< Updated upstream
=======
            finish()
        }

        val roomButton = findViewById<ImageButton>(R.id.btnRoom )

        roomButton.setOnClickListener()
        {
            val intent = Intent(this, PlayerRoom::class.java)

            startActivity(intent)
            finish()
        }

        val shopButton = findViewById<ImageButton>(R.id.btnShop )

        shopButton.setOnClickListener()
        {
            val intent = Intent(this, Shop::class.java)

            startActivity(intent)
            finish()
        }

        val categoryButton = findViewById<ImageButton>(R.id.btnCategory )

        categoryButton.setOnClickListener()
        {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            finish()
        }

        val dateButton = findViewById<ImageButton>(R.id.btnDate )

        dateButton.setOnClickListener()
        {
            val intent = Intent(this, Date::class.java)

            startActivity(intent)
            finish()
>>>>>>> Stashed changes
        }



=======
>>>>>>> parent of 66d9c21 (adding a timer)
=======
>>>>>>> parent of 66d9c21 (adding a timer)
=======
>>>>>>> parent of 66d9c21 (adding a timer)
    }
}