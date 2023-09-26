package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageButton

class Timer : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)



        val timerTextView = findViewById<TextView>(R.id.timerTextView)
        val startButton = findViewById<ImageButton>(R.id.btnStart)
        val stopButton = findViewById<ImageButton>(R.id.btnStop)
        val restartButton = findViewById<ImageButton>(R.id.btnRestart)
        var isTimerRunning = false
        var elapsedMillis = 0L
        var timer: CountUpTimer? = null


        // Set click listeners for your buttons
        startButton.setOnClickListener {
            if (!isTimerRunning) {
                isTimerRunning = true
                timer = CountUpTimer(0L, 1000) { elapsedMillis ->
                    val formattedTime = formatElapsedTime(elapsedMillis)
                    timerTextView.text = formattedTime
                }
                timer?.start()
            }
        }

        stopButton.setOnClickListener {
            if (isTimerRunning) {
                isTimerRunning = false
                timer?.cancel()
            }
        }

        restartButton.setOnClickListener {
            isTimerRunning = false
            timer?.cancel()
            elapsedMillis = 0L
            timerTextView.text = "00:00:00"
        }
    }

    private fun formatElapsedTime(elapsedMillis: Long): String {
        // Format elapsed time into hours, minutes, and seconds
        val hours = elapsedMillis / 3600000
        val minutes = (elapsedMillis % 3600000) / 60000
        val seconds = (elapsedMillis % 60000) / 1000
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }




    }





