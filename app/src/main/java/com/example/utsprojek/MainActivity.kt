package com.example.utsprojek

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.buttonLogin)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Assuming these values are fetched from a form or other input
            val nim = "2207411037"
            val name = "Tariss Azzahra Danantya"
            val kelas = "TI-4B"

            // Save to SharedPreferences
            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("email", email)
                putString("nim", nim)
                putString("name", name)
                putString("kelas", kelas)
                apply()
            }

            // Start ProfileActivity (you can change this to your desired activity)
            val intent = Intent(this, FragmentProfile::class.java)
            startActivity(intent)
        }

        // Handle click on register TextView
        val btnRegist = findViewById<TextView>(R.id.textViewRegist)
        btnRegist.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
