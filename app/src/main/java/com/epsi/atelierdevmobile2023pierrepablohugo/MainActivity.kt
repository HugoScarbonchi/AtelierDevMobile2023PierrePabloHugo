package com.epsi.atelierdevmobile2023pierrepablohugo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeaderTitle(getString(R.string.main_title))
        
        
        val infosButton=findViewById<Button>(R.id.infosButton)
        infosButton.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentOnlineActivity::class.java)
            startActivity(newIntent)
        })

        val productsButton = findViewById<Button>(R.id.productsButton)
        productsButton.setOnClickListener(View.OnClickListener {
            val vue = Intent(application, RayonsActivity::class.java)
            startActivity(vue)
        })


        /**

        val buttonEspace=findViewById<Button>(R.id.buttonEspace)
        buttonEspace.setOnClickListener(View.OnClickListener {
            val url="https://img.freepik.com/photos-gratuite/rendu-3d-fond-espace-planetes-abstraites-nebuleuse_1048-12994.jpg?w=740&t=st=1673970224~exp=1673970824~hmac=5db29203b7bcddbecb50f50b6bab3920b729055ce5b87aaccc3260362a801f19"
            val title=getString(R.string.title_espace)
            showDetailsActivity(url,title)
            Log.i("Epsi G1","Show Details Activity")
        })

        val buttonStudentsWs=findViewById<Button>(R.id.buttonStudentsWs)
        buttonStudentsWs.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentOnlineActivity::class.java)
            startActivity(newIntent)
        })

        **/
    }

    /**
    private fun showDetailsActivity(url:String,tilte:String) {
        val newIntent = Intent(application, DetailsActivity::class.java)
        newIntent.putExtra("url", url)
        newIntent.putExtra("title", tilte)
        startActivity(newIntent)
    }
    **/
}