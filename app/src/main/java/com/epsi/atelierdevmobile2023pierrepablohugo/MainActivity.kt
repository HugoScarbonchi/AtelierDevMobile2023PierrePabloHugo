package com.epsi.atelierdevmobile2023pierrepablohugo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeaderTitle(getString(R.string.main_title))

        //info button recuperation and click event listener
        val infosButton=findViewById<ConstraintLayout>(R.id.infoButton)
        infosButton.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentOnlineActivity::class.java)
            startActivity(newIntent)
        })

        //product button recuperation and click event listener
        val productsButton = findViewById<ConstraintLayout>(R.id.productButton)
        productsButton.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, RayonsActivity::class.java)
            startActivity(newIntent)
        })


    }
}