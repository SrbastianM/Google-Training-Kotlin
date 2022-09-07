package com.example.helloworld

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    lateinit var diceImage : ImageView
    lateinit var diceImages : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
            diceImage = findViewById(R.id.dice_image)
            diceImages = findViewById(R.id.dice_images)
        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clearDiceButton() }
    }

    private fun rollDice () {
        diceImage.setImageResource(getRandomDiceImages())
        diceImages.setImageResource(getRandomDiceImages())
        Toast.makeText(this, "Dice Rolled",
            Toast.LENGTH_SHORT).show()
    }
    private fun clearDiceButton (){
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImages.setImageResource(R.drawable.empty_dice)
        Toast.makeText(this, "Dice Cleared",
            Toast.LENGTH_SHORT).show()
    }
    private fun getRandomDiceImages (): Int {
        val randomInt = (1..6).random()
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}

