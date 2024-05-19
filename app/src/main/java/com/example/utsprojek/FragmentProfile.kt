package com.example.utsprojek

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentProfile : Fragment(R.layout.fragmentprofile) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragmentprofile, container, false)

        val sharedPreferences = activity?.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

        val email = sharedPreferences?.getString("email", "N/A")
        val nim = sharedPreferences?.getString("nim", "N/A")
        val name = sharedPreferences?.getString("name", "N/A")
        val kelas = sharedPreferences?.getString("kelas", "N/A")

        val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        val tvNim = view.findViewById<TextView>(R.id.tvNim)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvKelas = view.findViewById<TextView>(R.id.tvKelas)

        tvEmail.text = email
        tvNim.text = nim
        tvName.text = name
        tvKelas.text = kelas

        val btnLogout = view.findViewById<Button>(R.id.btnLogoutt)
        btnLogout.setOnClickListener {
            // Clear SharedPreferences (logout)
            sharedPreferences?.edit()?.clear()?.apply()

            // Start MainActivity (login screen)
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish() // Close the current activity
        }

        return view
    }
}