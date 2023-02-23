package com.epsi.atelierdevmobile2023pierrepablohugo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class StudentsActivity : BaseActivity() {
    /**
    val data="{\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"picture_url\": \"https://www.numerama.com/content/uploads/2019/05/trou-noir-espace-univers-astronomie.jpg\",\n" +
            "      \"name\": \"Allan\",\n" +
            "      \"email\": \"allan@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg\",\n" +
            "      \"name\": \"Arraud\",\n" +
            "      \"email\": \"arraud@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://media.gettyimages.com/photos/colorful-powder-explosion-in-all-directions-in-a-nice-composition-picture-id890147976?s=2048x2048\",\n" +
            "      \"name\": \"Nicolas\",\n" +
            "      \"email\": \"nicolas@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Lilian\",\n" +
            "      \"email\": \"lilian@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/2/3/1/2310c9171a_50157784_pia23441.jpg\",\n" +
            "      \"name\": \"Maxime\",\n" +
            "      \"email\": \"maxime@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"
**/


/**
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
                js.optString("phone","not found"),
                js.optString("city","not found"),
                js.optString("zipcode","not found"),
                js.optString("picture_url",url))
            students.add(student)
        }

        val recyclerviewStudents=findViewById<RecyclerView>(R.id.recyclerviewStudents)
        recyclerviewStudents.layoutManager=LinearLayoutManager(this)
        val studentAdapter=StudentAdapter(students)
        recyclerviewStudents.adapter=studentAdapter

    }
    **/
}