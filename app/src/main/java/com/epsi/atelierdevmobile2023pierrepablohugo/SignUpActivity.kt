package com.epsi.atelierdevmobile2023pierrepablohugo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        showBack()
        setHeaderTitle(getString(R.string.title_signup))

        val editTextFirstName=findViewById<EditText>(R.id.editTextFirstName)
        editTextFirstName.setText(readSharedPref("FirstName"))
        val editTextLastName=findViewById<EditText>(R.id.editTextLastName)
        editTextLastName.setText(readSharedPref("LastName"))
        val editTextAddress=findViewById<EditText>(R.id.editTextAddress)
        editTextAddress.setText(readSharedPref("Address"))
        val editTextCity=findViewById<EditText>(R.id.editTextCity)
        editTextCity.setText(readSharedPref("City"))
        val editTextEmail=findViewById<EditText>(R.id.editTextTextEmailAddress)
        editTextEmail.setText(readSharedPref("Email"))
        val editTextTextPassword=findViewById<EditText>(R.id.editTextTextPassword)
        editTextTextPassword.setText(readSharedPref("Password"))

        val buttonSignup=findViewById<Button>(R.id.buttonSignup)
        buttonSignup.setOnClickListener(View.OnClickListener {
            val txt=editTextFirstName.text.toString()+
                    " / "+editTextLastName.text.toString()+
                    " / "+editTextAddress.text.toString()+" / "+
                    " / "+editTextCity.text.toString()+" / "+
                    editTextEmail.text.toString()+" / "+
                    editTextTextPassword.text.toString()
            (application as EpsiApplication).showToast(txt)
            writeSharedPref("FirstName",editTextFirstName.text.toString());
            writeSharedPref("LastName",editTextLastName.text.toString());
            writeSharedPref("Address",editTextAddress.text.toString());
            writeSharedPref("City",editTextCity.text.toString());
            writeSharedPref("Email",editTextEmail.text.toString());
            writeSharedPref("Password",editTextTextPassword.text.toString());
        })
    }

    fun writeSharedPref(key:String,value:String){
        val sharedPreferences: SharedPreferences= getSharedPreferences("account",Context.MODE_PRIVATE)
        val editor =sharedPreferences.edit()
        editor.putString(key,value)
        editor.apply()
    }

    fun readSharedPref(key:String):String{
        val sharedPreferences: SharedPreferences= getSharedPreferences("account",Context.MODE_PRIVATE)
        return sharedPreferences.getString(key,"").toString()
    }

}