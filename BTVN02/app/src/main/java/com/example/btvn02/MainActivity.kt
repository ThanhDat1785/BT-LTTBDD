package com.example.btvn02

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val editName = findViewById<EditText>(R.id.editTextText)
        val editAge = findViewById<EditText>(R.id.editTextText2)
        val checkButton = findViewById<Button>(R.id.button)
        val resultText = findViewById<TextView>(R.id.textResult)

        checkButton.setOnClickListener {
            val ageStr = editAge.text.toString().trim()
            val nameStr = editName.text.toString().trim()

            if (ageStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập tuổi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val age = ageStr.toInt()
                val result = when {
                    age > 65 -> "Người già"
                    age in 6..65 -> "Người lớn"
                    age in 2..5 -> "Trẻ em"
                    else -> "Em bé"
                }

                resultText.text = "$nameStr là $result"
                resultText.setTextColor(android.graphics.Color.RED)

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Tuổi không hợp lệ", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
