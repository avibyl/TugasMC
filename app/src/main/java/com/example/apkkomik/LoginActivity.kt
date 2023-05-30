package com.example.apkkomik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.apkkomik.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


//      Tombol menuju halaman reset password
        binding.lupapassword.setOnClickListener {
            val intent = Intent(this, lupapassword::class.java)
            startActivity(intent)
        }

//      Tombol menuju halaman register
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.btnlogin.setOnClickListener {
            val email : String = binding.kemail.text.toString().trim()
            val pass  : String = binding.kpassword.text.toString().trim()

            if (email.isEmpty()){
                binding.kemail.error = "Email Tidak Boleh Kosong"
                binding.kemail.requestFocus()
                return@setOnClickListener

            }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.kemail.error = "Email Tidak Valid"
                binding.kemail.requestFocus()
                return@setOnClickListener

            }else if(pass.isEmpty() || pass.length < 8){
                binding.kpassword.error = "Maksimal 8 karakter dan Tidak boleh kosong"
                binding.kpassword.requestFocus()
                return@setOnClickListener

            }else{
                loginUser(email,pass)
            }

        }

    }
    private fun loginUser(email: String, pass: String) {
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
                Intent(this, ContenActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }

            } else {
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }

}
}
