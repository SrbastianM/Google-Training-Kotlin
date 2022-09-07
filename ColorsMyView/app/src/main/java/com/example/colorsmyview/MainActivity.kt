package com.example.colorsmyview

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun overColored(view: View)
    {
        when(view.id)
        {
            R.id.box_one_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_three_text -> view.setBackgroundColor(Color.CYAN)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.YELLOW)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners()
    {
        val boxOne = findViewById<TextView>(R.id.box_one_text)
        val boxTwo = findViewById<TextView>(R.id.box_two_text)
        val boxThree = findViewById<TextView>(R.id.box_three_text)
        val boxFour = findViewById<TextView>(R.id.box_four_text)
        val boxFive = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableList:
                List<View> = listOf(boxOne, boxTwo, boxThree, boxFour, boxFive, rootConstraintLayout)

        for (item in clickableList)
        {
            item.setOnClickListener { overColored(it) }
        }
    }
}