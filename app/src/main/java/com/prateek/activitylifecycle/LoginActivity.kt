package com.prateek.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(){

    lateinit var etMobileNumber:EditText
    lateinit var etPassword:EditText
    lateinit var btnLogin:Button
    lateinit var txtForgotPassword:TextView
    lateinit var txtRegister:TextView
    val validMobileNumber="8002072170"
    val validPassword=arrayOf("tony","steve","bruce","natasha","t'challa","thor")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences= getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)

        if(isLoggedIn){
            val intent=Intent(this@LoginActivity,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }
        title="Log In"

        etMobileNumber=findViewById(R.id.etNumber)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtForgotPassword=findViewById(R.id.txtForgotPassword)
        txtRegister=findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener {

            val mobileNumber=etMobileNumber.text.toString()
            val password=etPassword.text.toString()
            var nameOfAvenger="Avenger"
            val intent=Intent(this@LoginActivity,AvengersActivity::class.java)

            if(mobileNumber==validMobileNumber){
                if(password==validPassword[0]){
                    nameOfAvenger="Tony"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[1]){
                    nameOfAvenger="Steve"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }

                else if(password==validPassword[2]){
                    nameOfAvenger="Bruce"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[3]){
                    nameOfAvenger="Natasha"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[4]){
                    nameOfAvenger="T'Challa"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[5]){
                    nameOfAvenger="Thor"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }


            }
            else{
                Toast.makeText(this@LoginActivity, "Incorrect credentials",
                    Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("title",title).apply()
    }
}