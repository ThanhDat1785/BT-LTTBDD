package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast




class MainActivity : Activity() {

    private lateinit var editTextEmail: EditText
    private lateinit var button: Button
    private lateinit var textViewError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email)

        editTextEmail = findViewById(R.id.editTextText)
        button = findViewById(R.id.button2)
        textViewError = findViewById(R.id.textViewError)

        button.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            textViewError.visibility = TextView.GONE // ẩn lỗi mặc định

            when {
                email.isEmpty() -> {
                    textViewError.text = "Email không hợp lệ"
                    textViewError.visibility = TextView.VISIBLE
                }
                !email.contains("@") -> {
                    textViewError.text = "Email không đúng định dạng"
                    textViewError.visibility = TextView.VISIBLE
                }
                else -> {
                    textViewError.text = "Email đúng"
                    textViewError.setTextColor(0xFF000000.toInt()) // đen
                    textViewError.visibility = TextView.VISIBLE
                }
            }
        }
    }
}
