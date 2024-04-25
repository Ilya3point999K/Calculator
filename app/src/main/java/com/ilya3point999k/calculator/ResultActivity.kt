package com.ilya3point999k.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.properties.Delegates

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val op = intent.getIntExtra("op", 0)
        val first = intent.getFloatExtra("first", 0F)
        val second = intent.getFloatExtra("second", 0F)

        var result = 0F
        when (op){
            0 -> result = (first + second)
            1 -> result = (first - second)
            2 -> result = (first * second)
            3 -> result = (first / second)
        }
        var textView = findViewById<TextView>(R.id.ResultTextView)
        textView.text = result.toString()
    }

    fun back_button(view: View){
        finish()
    }
}