package com.example.luckyticketkotlin

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun onClick(view: View) {

        val max = 6
        val etNumber = findViewById<EditText>(R.id.et_ticket_number).text
        val bulb = findViewById<ImageView>(R.id.iv_image)

        if (etNumber.length == max) {

            try {
                val resultTicket = etNumber.toList().map { it.toString().toInt() }
                val firstPart = resultTicket.slice(0..2).reduce{total, next -> total + next}
                val secondPart = resultTicket.slice(3..5).reduce{total, next -> total + next}

                if(firstPart == secondPart)
                {
                    bulb.setImageResource(R.drawable.green_bulb)
                }
                else
                    {
                        bulb.setImageResource(R.drawable.red_bulb)
                    }
                }
            catch (e: NumberFormatException)
                {
                    Toast.makeText(
                        applicationContext,
                        "Enter your ticket number",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                                     }
        else
            {
                bulb.setImageResource(R.drawable.grey_bulb)
                Toast.makeText(
                    applicationContext,
                    "Minimum number of characters 6",
                    Toast.LENGTH_SHORT
                ).show()
            }



    }
}