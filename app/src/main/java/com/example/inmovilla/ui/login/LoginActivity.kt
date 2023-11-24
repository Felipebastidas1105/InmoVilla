package com.example.inmovilla.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.inmovilla.R
import com.example.inmovilla.databinding.ActivityLogin2Binding
import com.example.inmovilla.ui.homepage.HomeActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            if (binding.etname.text.toString() == "admin" ){
                if (binding.etpassword.text.toString() == "admin123"){
                    val intent = Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "User or password incorrect", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "No found user ${binding.etname.text.toString()}", Toast.LENGTH_SHORT).show()
            }
        }

    }
}