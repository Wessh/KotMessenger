package com.wessh.kotmessenger.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wessh.kotmessenger.R
import kotlinx.android.synthetic.main.act_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_register)

        btn_registrar.setOnClickListener {
            val email = reg_email.text.toString()
            val password = reg_password.text.toString()

            Log.i("Teste - ","Email: $email | Password: $password")
        }

    }
}
