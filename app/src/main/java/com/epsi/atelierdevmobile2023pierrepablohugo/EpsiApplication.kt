package com.epsi.atelierdevmobile2023pierrepablohugo

import android.app.Application
import android.widget.Toast

class EpsiApplication:Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    fun showToast(txt:String){
        Toast.makeText(this,txt,Toast.LENGTH_SHORT).show()
    }
}