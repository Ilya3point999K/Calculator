package com.ilya3point999k.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var firstNumber: EditText
    lateinit var secondNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstNumber = findViewById(R.id.FirstNumber) as EditText
        secondNumber = findViewById(R.id.SecondNumber) as EditText

        firstNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().trim().length == 2 && s.toString().trim()[0] == '0') {
                    firstNumber.setText("0")
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        secondNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().trim().length == 2 && s.toString().trim()[0] == '0') {
                    secondNumber.setText("0")
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    fun add_pressed(view: View){

        val intent = Intent(this, ResultActivity::class.java)
        var first: Float?
        var second: Float?

        first = firstNumber.text.toString().toFloatOrNull()
        second = secondNumber.text.toString().toFloatOrNull()
        if (first == null || second == null){
            Toast.makeText(this.applicationContext, getString(R.string.input_error), Toast.LENGTH_LONG).show()
        } else {
            intent.putExtra("first", first)
            intent.putExtra("second", second)
            intent.putExtra("op", 0)
            startActivity(intent)
        }
    }

    fun sub_pressed(view: View){
        val intent = Intent(this, ResultActivity::class.java)
        var first: Float?
        var second: Float?

        first = firstNumber.text.toString().toFloatOrNull()
        second = secondNumber.text.toString().toFloatOrNull()
        if (first == null || second == null){
            Toast.makeText(this.applicationContext, getString(R.string.input_error), Toast.LENGTH_LONG).show()
        } else {
            intent.putExtra("first", first)
            intent.putExtra("second", second)
            intent.putExtra("op", 1)
            startActivity(intent)
        }

    }

    fun mul_pressed(view: View){
        val intent = Intent(this, ResultActivity::class.java)
        var first: Float?
        var second: Float?

        first = firstNumber.text.toString().toFloatOrNull()
        second = secondNumber.text.toString().toFloatOrNull()
        if (first == null || second == null){
            Toast.makeText(this.applicationContext, getString(R.string.input_error), Toast.LENGTH_LONG).show()
        } else {
            intent.putExtra("first", first)
            intent.putExtra("second", second)
            intent.putExtra("op", 2)
            startActivity(intent)
        }

    }

    fun div_pressed(view: View){
        val intent = Intent(this, ResultActivity::class.java)
        var first: Float?
        var second: Float?

        first = firstNumber.text.toString().toFloatOrNull()
        second = secondNumber.text.toString().toFloatOrNull()
        if (first == null || second == null){
            Toast.makeText(this.applicationContext, getString(R.string.input_error), Toast.LENGTH_LONG).show()
        } else if (second == 0F){
            Toast.makeText(this.applicationContext, getString(R.string.zero_error), Toast.LENGTH_LONG).show()
        } else{
            intent.putExtra("first", first)
            intent.putExtra("second", second)
            intent.putExtra("op", 3)
            startActivity(intent)
        }

    }

}