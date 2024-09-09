package com.tugaspassing_lulunaurahhukama

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var eUser: EditText
    private lateinit var ePassword : EditText
    private lateinit var btnLogin : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        eUser = findViewById(R.id.eUser)
        ePassword = findViewById(R.id.ePassword)
        btnLogin = findViewById(R.id.btnLogin)


        btnLogin.setOnClickListener(){
            val nUsername = eUser.text.toString() // ini ngambil dari edit text kemudian convert ke string
            val nPassword = ePassword.text.toString()



            //Pasing data --> pengiriman data atau value dari satu activity ke activity lain
            //Intent --> put extras --> ini untuk penyimpanan dan pengiriman
            //get extras --> ini untuk pengembalian

            val intentPassingData = Intent(this@MainActivity,
                WelcomePageActivity::class.java)
            //proses put data
            intentPassingData.putExtra("username", nUsername)
            intentPassingData.putExtra("password", nPassword)
            //pindah dan membawa datanya

            startActivity(intentPassingData)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}