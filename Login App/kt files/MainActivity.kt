package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnlogin: Button
    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnlogin = findViewById(R.id.btnlogin)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        btnlogin.setOnClickListener {
            val senddata:Intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("Username",username.text.toString())
                putExtra("Password",password.text.toString())
            }


            startActivity(senddata)
        }

        }


    }
