package com.example.apkkomik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.apkkomik.databinding.ActivityLupapasswordBinding
import com.google.firebase.auth.FirebaseAuth

class lupapassword : AppCompatActivity() {
    private lateinit var binding: ActivityLupapasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityLupapasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.kkembali.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnReset.setOnClickListener {
            val email: String = binding.resetemail.text.toString().trim()

            if (email.isEmpty()) {
                binding.resetemail.error = "Email Tidak Boleh Kosong"
                binding.resetemail.requestFocus()
                return@setOnClickListener

            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.resetemail.error = "Email Tidak Valid"
                binding.resetemail.requestFocus()
                return@setOnClickListener

            } else {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Cek email untuk Reset Password", Toast.LENGTH_SHORT)
                            .show()
                        Intent(this, LoginActivity::class.java).also {
                            it.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                        }

                    } else {
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}