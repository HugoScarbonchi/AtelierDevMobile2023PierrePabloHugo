package com.epsi.atelierdevmobile2023pierrepablohugo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter (val students: ArrayList<Student>):RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.name.text = student.name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, StudentProfileActivity::class.java)

            intent.putExtra("name", student.name)
            intent.putExtra("email", student.email)
            intent.putExtra("group", student.group)
            intent.putExtra("description", student.description)
            intent.putExtra("imgUrl", student.imgUrl)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name = itemView.findViewById(R.id.name) as TextView
    }

}
