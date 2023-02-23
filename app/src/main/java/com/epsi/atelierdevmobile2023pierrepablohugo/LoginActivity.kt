package com.epsi.atelierdevmobile2023pierrepablohugo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setHeaderTitle(getString(R.string.title_login))
        showBack()

        val editTextEmail=findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextTextPassword=findViewById<EditText>(R.id.editTextTextPassword)

        val buttonGo=findViewById<Button>(R.id.buttonGo)
        buttonGo.setOnClickListener(View.OnClickListener {
            val txt=editTextEmail.text.toString()+" / "+editTextTextPassword.text.toString()
            (application as EpsiApplication).showToast(txt)
        })
    }
}