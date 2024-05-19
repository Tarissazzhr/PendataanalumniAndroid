package com.example.utsprojek

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etNim = findViewById<EditText>(R.id.etNim)
        val etName = findViewById<EditText>(R.id.etName)
        val etKelas = findViewById<EditText>(R.id.etKelas)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val email = etEmail.text.toString()
            val nim = etNim.text.toString()
            val name = etName.text.toString()
            val kelas = etKelas.text.toString()

            // Save user details to SharedPreferences
            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("email", email)
                putString("nim", nim)
                putString("name", name)
                putString("kelas", kelas)
                apply()
            }

            // Redirect to MainActivity (login screen) after registration
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Close the RegisterActivity
        }
    }
}