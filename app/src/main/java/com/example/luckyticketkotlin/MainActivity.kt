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

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun onClick(view: View)
    {
        val etNumber = findViewById<EditText>(R.id.et_ticket_number).text.toString()
        val bulb = findViewById<ImageView>(R.id.iv_image)
        val resultTicket: String

        if (etNumber.length != 6)
        {
            bulb.setImageResource(R.drawable.grey_bulb)
            Toast.makeText(applicationContext, "Minimum number of characters 6",
                Toast.LENGTH_SHORT).show()
        } else
        {
            if (getResult(etNumber))
            {
                bulb.setImageResource(R.drawable.green_bulb)
            } else
            {
                bulb.setImageResource(R.drawable.red_bulb)
            }
        }
    }

    private fun getResult(num: String): Boolean
    {
        return sumNumber(num, 0) == sumNumber(num, num.length - 3)
    }

    private fun sumNumber(num: String, index: Int): Int
    {
        var sum = 0
        for (i in index until index + 3) sum += Character.digit(num[i], 10)
        return sum
    }
}