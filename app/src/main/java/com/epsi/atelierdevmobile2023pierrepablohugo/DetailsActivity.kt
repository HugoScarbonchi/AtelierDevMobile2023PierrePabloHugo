package com.epsi.atelierdevmobile2023pierrepablohugo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class etailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val url=intent.extras!!.getString("url")
        val image=findViewById<ImageView>(R.id.imageViewDetails)
        Picasso.get().load(url).into(image);
        val title=intent.extras!!.getString("title")

        setHeaderTitle(title)
        showBack()
    }
}