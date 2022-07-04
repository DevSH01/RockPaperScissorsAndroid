package com.example.rockpaperscissors

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rockpaperscissors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Choices
        val androOptions = listOf("Rock", "Paper", "Scissors")
        var playerChoice = ""
        var androChoice = ""
        fun setPlayerChoice(set: String) {
            playerChoice = set
        }
        fun setAndroChoice() {
            androChoice = androOptions[(Math.random()*androOptions.size).toInt()]
        }
        fun displayChoices() {
            binding.androChoiceBox.setText(androChoice)
            binding.playerChoiceBox.setText(playerChoice)
        }

        //Score system
        var androScore = 0
        var playerScore = 0
        fun androScoreUp() {
            androScore += 1
        }
        fun playerScoreUp() {
            playerScore += 1
        }
        fun displayScore() {
            binding.scoreboard.setText("Android $androScore - Player $playerScore")
        }
        displayScore()

        //Result
        fun displayResult() {
            if (androChoice == playerChoice) {
                Toast.makeText(applicationContext, "Draw!", Toast.LENGTH_SHORT).show()
            } else if (
                (androChoice == "Rock" && playerChoice == "Scissors") ||
                (androChoice == "Paper" && playerChoice == "Rock") ||
                (androChoice == "Scissors" && playerChoice == "Paper")
            ) {
                Toast.makeText(applicationContext, "You lose!", Toast.LENGTH_SHORT).show()
                androScoreUp()
            } else {
                Toast.makeText(applicationContext, "You win!", Toast.LENGTH_SHORT).show()
                playerScoreUp()
            }
        }

        //Main
        fun mainExecution(set: String) {
            setPlayerChoice(set)
            setAndroChoice()
            displayChoices()
            displayResult()
            displayScore()
        }

        //Execution
        binding.btnRock.setOnClickListener {
            mainExecution("Rock")
        }
        binding.btnPaper.setOnClickListener {
            mainExecution("Paper")
        }
        binding.btnScissors.setOnClickListener {
            mainExecution("Scissors")
        }
    }
}
