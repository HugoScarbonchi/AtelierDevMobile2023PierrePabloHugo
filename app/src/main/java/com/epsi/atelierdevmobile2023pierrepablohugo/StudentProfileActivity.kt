package com.epsi.atelierdevmobile2023pierrepablohugo

import android.os.Bundle

class StudentProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        val name = intent.getStringExtra("name")
        setHeaderTitle(name)
        showBack()
    }
}