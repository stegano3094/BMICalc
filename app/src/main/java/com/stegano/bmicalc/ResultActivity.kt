package com.stegano.bmicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import kotlin.math.pow
import kotlin.math.roundToInt

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val weight = intent.getStringExtra("weight")
        val height = intent.getStringExtra("height")

        val bmi = Integer.parseInt(weight) / (Integer.parseInt(height) / 100.0).pow(2.0)
        Toast.makeText(this, "결과가 나왔습니다. bmi : ${bmi.roundToInt()}", Toast.LENGTH_SHORT).show()

        when {
            bmi >= 35 -> {
                resultTextView.text = "고도 비만입니다."
                resultImageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
            }
            bmi >= 30 -> {
                resultTextView.text = "2단계 비만입니다."
                resultImageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
            }
            bmi >= 25 -> {
                resultTextView.text = "1단계 비만입니다."
                resultImageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
            }
            bmi >= 23 -> {
                resultTextView.text = "과체중입니다."
                resultImageView.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
            }
            bmi >= 18.5 -> resultTextView.text = "정상입니다."
            else -> {
                resultTextView.text = "저체중입니다."
                resultImageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
            }
        }
    }
}