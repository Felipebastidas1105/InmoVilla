package com.example.inmovilla.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.cronodepro.core.Constant
import com.example.cronodepro.core.InmovillaPreferencesHelper
import com.example.inmovilla.core.Resource
import com.example.inmovilla.databinding.ActivityLogin2Binding
import com.example.inmovilla.ui.homepage.HomeActivity
import com.example.inmovilla.ui.initial.MainActivity
import com.example.shinyapplication.domain.model.login.Login
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLogin2Binding

    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var dataLogin: Login

    @Inject
    lateinit var inmovillaPreferencesHelper: InmovillaPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

    }

    private fun initUI() {
        initListener()
    }

    private fun initViewModel(dataLogin: Login) {
        viewModel.authLogin.observe(this) {
            when (it) {
                is Resource.Error -> {
                    println(it.message)
                    if (it.message == "Error in the service"){
                        binding.tvErrorMesagge.text = "Usuario y/o Contraseña incorrecta"
                    }
                    else{
                        binding.tvErrorMesagge.text = "Intenta mas tarde"
                    }
                    binding.progressBar.isVisible = false
                    binding.tvErrorMesagge.isVisible = true
                }

                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.tvErrorMesagge.isVisible = false
                }

                is Resource.Success -> {
                    binding.progressBar.isVisible = false
                    binding.tvErrorMesagge.isVisible = false

                    if (it.data != null) {
                        Constant.AUTHO_JWT = it.data.data
                        finish()
                        startActivity(Intent(this, HomeActivity::class.java))
                        inmovillaPreferencesHelper.putBoolean("login_logout",true)
                    }
                }

            }
        }

        viewModel.getAuthLogin(dataLogin)
    }

    private fun initListener() {
        val isLogin = inmovillaPreferencesHelper.getBoolean("login_logout",false)
        binding.btnSubmit.setOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)

            if (binding.etname.text.isNullOrEmpty() || binding.etpassword.text.isNullOrEmpty()) {
                return@setOnClickListener
            } else {
                dataLogin =
                    Login(binding.etname.text.toString().trim(), binding.etpassword.text.toString())
                initViewModel(dataLogin)
            }
        }

    }
}