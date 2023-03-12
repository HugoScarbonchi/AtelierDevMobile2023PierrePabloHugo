package com.epsi.atelierdevmobile2023pierrepablohugo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RayonAdapter (val rayons: ArrayList<Rayon>):RecyclerView.Adapter<RayonAdapter.ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewId = view.findViewById<TextView>(R.id.textViewId)
        val textViewNom = view.findViewById<TextView>(R.id.textViewNom)
        val layoutContent= view.findViewById<ConstraintLayout>(R.id.layoutContent)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_rayon, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rayon = rayons.get(position)
        holder.textViewId.text=rayon.id
        holder.textViewNom.text=rayon.title
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            val intent = Intent(holder.layoutContent.context, ProductsActivity::class.java)

            intent.putExtra("rayonId", rayon.id)
            intent.putExtra("rayonTitle", rayon.title)
            intent.putExtra("url", rayon.productUrl)

            holder.layoutContent.context.startActivity(intent)

        })
    }

    override fun getItemCount(): Int {
        return rayons.size
    }
}
