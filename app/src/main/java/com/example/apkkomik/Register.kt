package com.example.apkkomik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.apkkomik.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        firebaseAuth = FirebaseAuth.getInstance()

        binding.kSingup.setOnClickListener {
            val email: String = binding.remail.text.toString().trim()
            val password: String = binding.rpassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.remail.error = "Input username"
                binding.rpassword.requestFocus()
                return@setOnClickListener

            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.remail.error = "Email tidak valid"
                binding.remail.requestFocus()
                return@setOnClickListener

            } else if (password.isEmpty() || password.length < 8) {
                binding.rpassword.error = "Minimal 8 karakter dan Tidak boleh kosong"
                binding.rpassword.requestFocus()
                return@setOnClickListener

            } else {
                registerUser(email, password)
            }

        }
    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Berhasil Mendaftar", Toast.LENGTH_SHORT).show()
                Intent(this, LoginActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }

            } else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }

        }
    }
}