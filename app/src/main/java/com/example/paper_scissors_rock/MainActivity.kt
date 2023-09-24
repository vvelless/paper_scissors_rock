package com.example.paper_scissors_rock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rock_button = findViewById<Button>(R.id.rock)
        val scissors_button = findViewById<Button>(R.id.scissors)
        val paper_button = findViewById<Button>(R.id.paper)


        rock_button.setOnClickListener {
            startGame("rock")
        }

        scissors_button.setOnClickListener {
            startGame("scissors")
        }

        paper_button.setOnClickListener {
            startGame("paper")
        }
    }
    private fun startGame(userChoice: String) {
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("userChoice", userChoice)
        startActivity(intent)
    }
}