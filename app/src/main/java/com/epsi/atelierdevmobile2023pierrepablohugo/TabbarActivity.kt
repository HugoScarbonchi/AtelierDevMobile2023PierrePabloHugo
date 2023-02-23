package com.epsi.atelierdevmobile2023pierrepablohugo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class TabbarActivity : BaseActivity() {

    val tab1Fragment=Tab1Fragment.newInstance("","")
    val tab2Fragment=Tab2Fragment.newInstance("","")
    val tab3Fragment=Tab3Fragment.newInstance("","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabbar)
        showBack()
        setHeaderTitle("Tab-Bar")
        val textViewTab1 = findViewById<TextView>(R.id.textViewTab1)
        val textViewTab2 = findViewById<TextView>(R.id.textViewTab2)
        val textViewTab3 = findViewById<TextView>(R.id.textViewTab3)

        textViewTab1.setOnClickListener(View.OnClickListener {
            showTab1()
        })

        textViewTab2.setOnClickListener(View.OnClickListener {
            showTab2()
        })


        textViewTab3.setOnClickListener(View.OnClickListener {
            showTab3()
        })

        showTab1()
    }

    fun showTab1(){
        val frManager= supportFragmentManager
        val fragmentTra=frManager.beginTransaction()
        fragmentTra.addToBackStack("Tab1")
        fragmentTra.replace(R.id.fragmentContent,tab1Fragment)
        fragmentTra.commit()
    }

    fun showTab2(){
        val frManager= supportFragmentManager
        val fragmentTra=frManager.beginTransaction()
        fragmentTra.addToBackStack("Tab2")
        fragmentTra.replace(R.id.fragmentContent,tab2Fragment)
        fragmentTra.commit()
    }

    fun showTab3(){
        val frManager= supportFragmentManager
        val fragmentTra=frManager.beginTransaction()
        fragmentTra.addToBackStack("Tab3")
        fragmentTra.replace(R.id.fragmentContent,tab3Fragment)
        fragmentTra.commit()
    }
}