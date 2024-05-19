package com.example.utsprojek

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentProfile : Fragment(R.layout.fragmentprofile) {
    private lateinit var userEmail: String
    private lateinit var userNim: String
    private lateinit var userName: String
    private lateinit var userKelas: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragmentprofile, container, false)

        // Retrieve user data from SharedPreferences
        val sharedPreferences = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        userEmail = sharedPreferences.getString("email", "N/A") ?: "N/A"
        userNim = sharedPreferences.getString("nim", "N/A") ?: "N/A"
        userName = sharedPreferences.getString("name", "N/A") ?: "N/A"
        userKelas = sharedPreferences.getString("kelas", "N/A") ?: "N/A"

        // Display user data in TextViews
        view.findViewById<TextView>(R.id.tvEmail).text = "Email: $userEmail"
        view.findViewById<TextView>(R.id.tvNim).text = "NIM: $userNim"
        view.findViewById<TextView>(R.id.tvName).text = "Name: $userName"
        view.findViewById<TextView>(R.id.tvKelas).text = "Class: $userKelas"

        return view
    }
}