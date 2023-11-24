package com.example.inmovilla.ui.initial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.inmovilla.databinding.ActivityMainBinding
import com.example.inmovilla.ui.login.LogActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var second:Long = 5 * 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        RegressiveCount()
    }

    private fun RegressiveCount() {
        var countDownTimer = object : CountDownTimer(second, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                changeView()
            }
        }
        countDownTimer.start()
    }

    private fun changeView() {
         val intent = Intent(this,LogActivity::class.java)
        startActivity(intent)
    }
}