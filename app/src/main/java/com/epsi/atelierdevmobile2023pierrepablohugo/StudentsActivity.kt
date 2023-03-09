package com.epsi.atelierdevmobile2023pierrepablohugo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class StudentsActivity : BaseActivity() {
    val data="{\n" +
            "  \"items\": [\n" +

            "    {\n" +
            "      \"name\": \"Allan\",\n" +
            "      \"email\": \"allan@epsi.fr\",\n" +
            "      \"group\": \"Groupe Dev2\",\n" +
            "      \"description\": \"mmmmh le caca c est delicieux\",\n" +
            "      \"imgUrl\": \"https://www.numerama.com/content/uploads/2019/05/trou-noir-espace-univers-astronomie.jpg\",\n" +
            "    },\n" +

            "    {\n" +
            "      \"name\": \"Allan\",\n" +
            "      \"email\": \"allan@epsi.fr\",\n" +
            "      \"group\": \"Groupe Dev2\",\n" +
            "      \"description\": \"mmmmh le caca c est delicieux\",\n" +
            "      \"imgUrl\": \"https://www.numerama.com/content/uploads/2019/05/trou-noir-espace-univers-astronomie.jpg\",\n" +
            "    },\n" +

            "    {\n" +
            "      \"name\": \"Allan\",\n" +
            "      \"email\": \"allan@epsi.fr\",\n" +
            "      \"group\": \"Groupe Dev2\",\n" +
            "      \"description\": \"mmmmh le caca c est delicieux\",\n" +
            "      \"imgUrl\": \"https://www.numerama.com/content/uploads/2019/05/trou-noir-espace-univers-astronomie.jpg\",\n" +
            "    },\n" +

            "  ]\n" +
            "}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)
        showBack()
        setHeaderTitle(getString(R.string.title_students))
        val url="https://img.freepik.com/photos-gratuite/rendu-3d-fond-espace-planetes-abstraites-nebuleuse_1048-12994.jpg?w=740&t=st=1673970224~exp=1673970824~hmac=5db29203b7bcddbecb50f50b6bab3920b729055ce5b87aaccc3260362a801f19"

        val students= arrayListOf<Student>()
        val jsStudents=JSONObject(data)
        val jsArrayStudents=jsStudents.getJSONArray("items")
        for(i in 0 until jsArrayStudents.length()){
            val js=jsArrayStudents.getJSONObject(i)
            val student=Student(js.optString("name","not found"),
                js.optString("email","not found"),
                js.optString("group","not found"),
                js.optString("description","not found"),
                js.optString("imgUrl","not found"))
            students.add(student)
        }

        val recyclerviewStudents=findViewById<RecyclerView>(R.id.recyclerviewStudents)
        recyclerviewStudents.layoutManager=LinearLayoutManager(this)
        val studentAdapter=StudentAdapter(students)
        recyclerviewStudents.adapter=studentAdapter

    }
}