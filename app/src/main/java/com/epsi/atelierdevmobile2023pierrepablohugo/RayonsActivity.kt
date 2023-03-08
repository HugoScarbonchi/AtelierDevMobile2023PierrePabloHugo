package com.epsi.atelierdevmobile2023pierrepablohugo

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class RayonsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rayons)
        showBack()
        setHeaderTitle(getString(R.string.title_rayons))

        val rayons= arrayListOf<Rayon>()
        val url="https://img.freepik.com/photos-gratuite/rendu-3d-fond-espace-planetes-abstraites-nebuleuse_1048-12994.jpg?w=740&t=st=1673970224~exp=1673970824~hmac=5db29203b7bcddbecb50f50b6bab3920b729055ce5b87aaccc3260362a801f19"

        val recyclerviewRayons=findViewById<RecyclerView>(R.id.recyclerviewRayons)
        recyclerviewRayons.layoutManager= LinearLayoutManager(this)
        val rayonAdapter=RayonAdapter(rayons)
        recyclerviewRayons.adapter=rayonAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val requestUrl="https://www.ugarit.online/epsi/categories.json"
        val request = Request.Builder()
            .url(requestUrl)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if(data!=null) {
                    val jsStudents = JSONObject(data)
                    val jsArrayStudents = jsStudents.getJSONArray("items")
                    for (i in 0 until jsArrayStudents.length()) {
                        val js = jsArrayStudents.getJSONObject(i)
                        val rayon = Rayon(
                            js.optString("category_id", "not found"),
                            js.optString("title", "not found"),
                            js.optString("products_url", url)
                        )
                        rayons.add(rayon)
                        runOnUiThread(Runnable {
                            rayonAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }

        })
    }
}