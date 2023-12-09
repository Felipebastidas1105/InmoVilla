package com.example.inmovilla.ui.initial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.inmovilla.databinding.ActivityMainBinding
import com.example.inmovilla.ui.login.LogActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var second: Long = 5 * 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intiUI()

    }


    private fun intiUI() {
        binding.Logo.animate().alpha(0f).setDuration(0).withEndAction {
            binding.Logo.animate().alpha(1f).setDuration(2000).withEndAction {
                changeView()
            }
        }
    }

    private fun changeView() {
        val intent = Intent(this, LogActivity::class.java)
        startActivity(intent)
    }
}