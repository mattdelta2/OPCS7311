package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val loginButton = findViewById<ImageButton>(R.id.btnLogin)

        loginButton.setOnClickListener()
        {
            handleLogin()
        }
    }


    private fun handleLogin()
    {

        if(isLoginSuccessful())
        {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun isLoginSuccessful(): Boolean
    {
        return true
    }
}