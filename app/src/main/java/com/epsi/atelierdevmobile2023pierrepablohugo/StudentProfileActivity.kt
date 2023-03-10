package com.epsi.atelierdevmobile2023pierrepablohugo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.picasso.Picasso


class StudentProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_profile)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val group = intent.getStringExtra("group")
        val description = intent.getStringExtra("description")
        val imgUrl = intent.getStringExtra("imgUrl")
        val student = Student(name.toString(), email.toString(), group.toString(), description.toString(), imgUrl.toString())
        setHeaderTitle(name)
        showBack()

        findViewById<TextView>(R.id.name).text = student.name
        findViewById<TextView>(R.id.email).text = student.email
        findViewById<TextView>(R.id.group).text = student.group
        findViewById<TextView>(R.id.description).text = student.description

        Picasso.get().load(imgUrl).into(findViewById<ImageView>(R.id.profilePicture))

        findViewById<ConstraintLayout>(R.id.goEpsi).setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.epsi.fr"))
            startActivity(browserIntent)
        }


    }
}