package com.example.paper_scissors_rock

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class GameActivity : AppCompatActivity() {
    private val userChoice: String by lazy {intent.getStringExtra("userChoice") ?: ""}
    private val computerChoice: String by lazy {generateCompChoice()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val result_text = findViewById<TextView>(R.id.result)
        val result = getWinner(userChoice, computerChoice)
        val info = "Your choice was $userChoice and computer chose $computerChoice.\n $result"
        result_text.text = info
    }

    private fun generateCompChoice():String{
        val choices = listOf("rock", "scissors", "paper")
        return choices.random()
    }
    private fun getWinner(userChoice: String, computerChoice: String):String{
        if (userChoice == computerChoice) {
            return "Tie"
        } else if ((userChoice == "rock" && computerChoice == "scissors") ||
            (userChoice == "scissors" && computerChoice == "paper") ||
            (userChoice == "paper" && computerChoice == "rock")) {
            return "You win!"
        } else {
            return "You lose..("
        }
    }
}