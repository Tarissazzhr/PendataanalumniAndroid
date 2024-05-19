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
        val etName = findViewById<EditText>(R.id.etName)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etClass = findViewById<EditText>(R.id.etKelas)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val email = etEmail.text.toString()
            val name = etName.text.toString()
            val password = etPassword.text.toString()
            val kelas = etClass.text.toString()

            // Simpan informasi pengguna ke SharedPreferences
            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("email", email)
                putString("name", name)
                putString("password", password)
                putString("class", kelas)
                apply()
            }

            // Pindah ke halaman profil setelah registrasi
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
