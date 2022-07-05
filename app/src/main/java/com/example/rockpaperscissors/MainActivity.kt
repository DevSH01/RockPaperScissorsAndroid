package com.example.rockpaperscissors

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        //Attempts counter
        var attemptsCount = 0
        fun attemptsCountUp() {
            attemptsCount += 1
        }
        fun displayAttemptsCount() {
            binding.attemptsTaken.setText("Attempts: $attemptsCount")
        }
        displayAttemptsCount()

        //Result
        fun resultMessage(message: String) {
            binding.resultBox.setText(message)
        }
        fun displayResult() {
            if (androChoice == playerChoice) {
                resultMessage("It's a draw!")
            } else if (
                (androChoice == "Rock" && playerChoice == "Scissors") ||
                (androChoice == "Paper" && playerChoice == "Rock") ||
                (androChoice == "Scissors" && playerChoice == "Paper")
            ) {
                resultMessage("You lose!")
                androScoreUp()
            } else {
                resultMessage("You win!")
                playerScoreUp()
            }
        }

        //Main
        fun mainExecution(set: String) {
            attemptsCountUp()
            setPlayerChoice(set)
            setAndroChoice()
            displayChoices()
            displayResult()
            displayScore()
            displayAttemptsCount()
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
