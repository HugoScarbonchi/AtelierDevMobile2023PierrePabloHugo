package com.epsi.atelierdevmobile2023pierrepablohugo

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class ProductsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val url = intent.getStringExtra("url")
        val title = intent.getStringExtra("rayonTitle")
        val rayon = intent.getStringExtra("rayonId")

        setHeaderTitle(title)
        showBack()

        val produits = arrayListOf<Product>()
        val recyclerviewProduits = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerviewProduits.layoutManager = LinearLayoutManager(this)
        val produitAdapter = ProductsAdapter(produits)
        recyclerviewProduits.adapter = produitAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        if (url != null) {
            val request = Request.Builder()
                .url(url)
                .get()
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()

            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(call: Call, response: Response) {
                    val data = response.body?.string()

                    if (data != null) {
                        val jsProducts = JSONObject(data)
                        val jsArrayProducts = jsProducts.getJSONArray("items")
                        for (i in 0 until jsArrayProducts.length()) {
                            val js = jsArrayProducts.getJSONObject(i)
                            val product = Product(
                                js.optString("name", "not found"),
                                js.optString("description", "not found"),
                                js.optString("picture_url", url)
                            )
                            produits.add(product)
                        }
                        runOnUiThread {
                            produitAdapter.notifyDataSetChanged()
                        }
                    }
                }


            })
        }

    }


}