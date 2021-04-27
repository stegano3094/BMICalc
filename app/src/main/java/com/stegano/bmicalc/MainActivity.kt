package com.stegano.bmicalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.calc)
        val inputUserWeight = findViewById<EditText>(R.id.inputUserWeight)
        val inputUserHeight = findViewById<EditText>(R.id.inputUserHeight)

        button?.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("weight", inputUserWeight.text.toString())
            intent.putExtra("height", inputUserHeight.text.toString())

            inputUserWeight.setText("")  // 입력값 초기화
            inputUserHeight.setText("")

            startActivity(intent)
        }
    }
}