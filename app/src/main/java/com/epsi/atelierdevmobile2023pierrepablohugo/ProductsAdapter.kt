package com.epsi.atelierdevmobile2023pierrepablohugo

import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ProductsAdapter (val products: ArrayList<Product>): RecyclerView.Adapter<ProductsAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textViewNom = view.findViewById<TextView>(R.id.textViewNomProduct)
        val textViewDesc = view.findViewById<TextView>(R.id.textViewDescProduct)
        val imgViewImg = view.findViewById<ImageView>(R.id.imageViewProduct)
        val layoutContent= view.findViewById<LinearLayout>(R.id.layoutContent)

        init {
            textViewDesc.maxLines = 2
            textViewDesc.ellipsize = TextUtils.TruncateAt.END
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.textViewNom.text=product.nom
        holder.textViewDesc.text=product.desc
        Picasso.get().load(product.imageUrl).into(holder.imgViewImg)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductsMaxiDetailsActivty::class.java)

            intent.putExtra("name", product.nom)
            intent.putExtra("desc", product.desc)
            intent.putExtra("imgUrl", product.imageUrl)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }



}