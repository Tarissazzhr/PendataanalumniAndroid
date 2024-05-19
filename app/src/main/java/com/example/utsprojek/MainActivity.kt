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

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)

        // Dummy email and password for demonstration
        val validEmail = "user@example.com"
        val validPassword = "1234"


        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Validating email and password
            if (email == validEmail && password == validPassword) {
                // Save email to SharedPreferences
                val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    putString("email", email)
                    apply()
                }

                // Start HomeActivity after successful login
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Close MainActivity
            } else {
                // Show error message for invalid credentials
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle click on register TextView
        val btnRegist = findViewById<TextView>(R.id.textViewRegist)
        btnRegist.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
