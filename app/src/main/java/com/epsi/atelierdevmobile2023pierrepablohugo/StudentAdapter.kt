package com.epsi.atelierdevmobile2023pierrepablohugo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
class StudentAdapter (val students: ArrayList<Student>):RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        val textViewCity = view.findViewById<TextView>(R.id.textViewCity)
        val textViewZipcode = view.findViewById<TextView>(R.id.textViewZipcode)
        val textViewPhone = view.findViewById<TextView>(R.id.textViewPhone)
        val imageViewStudent = view.findViewById<ImageView>(R.id.imageViewStudent)
        val layoutContent= view.findViewById<LinearLayout>(R.id.layoutContent)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_student, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students.get(position)
        holder.textViewName.text=student.name
        holder.textViewEmail.text=student.email
        holder.textViewCity.text=student.city
        holder.textViewZipcode.text=student.zipcode
        holder.textViewPhone.text=student.phone
        Picasso.get().load(student.imgUrl).into(holder.imageViewStudent)
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.layoutContent.context,student.name,Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return students.size
    }
}
