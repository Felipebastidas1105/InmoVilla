package com.example.inmovilla.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inmovilla.R
import com.example.inmovilla.databinding.ActivityLoginBinding
import com.example.inmovilla.ui.homepage.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { goToLoginView() }
        binding.btnRegister.setOnClickListener { gotToRegister() }

    }


    private fun gotToRegister() {
        val intent = Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
    private fun goToLoginView() {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}