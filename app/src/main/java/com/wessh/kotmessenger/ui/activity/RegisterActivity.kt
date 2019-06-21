package com.wessh.kotmessenger.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.wessh.kotmessenger.R
import kotlinx.android.synthetic.main.act_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_register)

        btn_registrar.setOnClickListener {
            createUser()
        }

        btn_photo.setOnClickListener {
            selectPhoto()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            val mSelectedUri = data?.data
            Log.i("Teste", mSelectedUri.toString())
        }
    }


    private fun selectPhoto(){ //Reler paginas 147 e 148
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 0)
    }

    private fun createUser(){
        val email = reg_email.text.toString()
        val password = reg_password.text.toString()

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,
                "email e senha devem ser informados",
                Toast.LENGTH_LONG).show()
            return
        }
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
            if(it.isSuccessful){
                Log.i("Teste", "UserId é ${it.result?.user?.uid}")
            }
        }.addOnFailureListener {
                Log.e("Teste :", it.message, it)
            }
    }
}
