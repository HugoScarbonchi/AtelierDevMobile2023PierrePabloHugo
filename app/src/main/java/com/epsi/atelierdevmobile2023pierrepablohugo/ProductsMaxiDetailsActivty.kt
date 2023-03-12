package com.epsi.atelierdevmobile2023pierrepablohugo

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductsMaxiDetailsActivty : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_details)


        val name = intent.getStringExtra("name")
        val desc = intent.getStringExtra("desc")
        val imgUrl = intent.getStringExtra("imgUrl")
        val product = Product(name.toString(), desc.toString(), imgUrl.toString())
        setHeaderTitle(name)
        showBack()

        findViewById<TextView>(R.id.description).text = product.desc

        Picasso.get().load(imgUrl).into(findViewById<ImageView>(R.id.profilePicture))

        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenWidth = displayMetrics.widthPixels
        val maxWidth = (screenWidth * 0.7).toInt()
        textViewTitle.maxWidth = maxWidth

    }

}