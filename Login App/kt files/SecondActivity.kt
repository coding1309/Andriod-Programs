package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    private lateinit var btnperv: Button
    private lateinit var passtxt: TextView
    private lateinit var usertxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)


        passtxt = findViewById<TextView>(R.id.passtxt)
        usertxt = findViewById<TextView>(R.id.usertxt)

        usertxt.text = intent.getStringExtra("Username").toString()
        passtxt.text = intent.getStringExtra("Password").toString()
        btnperv = findViewById(R.id.btnperv)
        btnperv.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

        }
    }
}