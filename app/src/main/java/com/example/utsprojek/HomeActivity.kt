package com.example.utsprojek

import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.utsprojek.databinding.ActivityHomeBinding
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragmenthomeBtn.setOnClickListener {
            replaceFragment(FragmentHome())
        }
        binding.fragmentberitaBtn.setOnClickListener {
            replaceFragment(FragmentBerita())
        }
        binding.fragmentprofileBtn.setOnClickListener {

            replaceFragment(FragmentProfile())
        }

    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }

}