package com.wessh.kotmessenger.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.wessh.kotmessenger.R
import kotlinx.android.synthetic.main.act_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_login)

        btn_login.setOnClickListener {
            singIn()
        }

        txt_account.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun singIn(){
        val email = log_email.text.toString()
        val password = log_password.text.toString()

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"email e senha devem ser informados", Toast.LENGTH_LONG).show()
            return
        }

        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    Log.i("Teste :", "Usuario Logado ${it.result?.user?.uid}")
                }
            }.addOnFailureListener {
                Log.e("Teste :", it.message,it)
            }

    }
}
