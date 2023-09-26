package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val loginButton = findViewById<Button>(R.id.btm_Login)

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