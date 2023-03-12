package com.epsi.atelierdevmobile2023pierrepablohugo

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class StudentsActivity : BaseActivity() {
    val data="{\n" +
            "  \"items\": [\n" +

            "    {\n" +
            "      \"name\": \"Allan\",\n" +
            "      \"email\": \"allan@epsi.fr\",\n" +
            "      \"group\": \"Groupe Dev1\",\n" +
            "      \"description\": \"Étudiant en troisième année à l’EPSI parcours bachelor concepteur développeur de solution applicative\",\n" +
            "      \"imgUrl\": \"https://d2y5h3osumboay.cloudfront.net/08v5e2c0n6qf9w47ve48v2c3tqls\"\n" +
            "    },\n" +

            "    {\n" +
            "      \"name\": \"Bobby\",\n" +
            "      \"email\": \"bobby@epsi.fr\",\n" +
            "      \"group\": \"Groupe Dev1\",\n" +
            "      \"description\": \"Étudiant en troisième année à l’EPSI parcours bachelor concepteur développeur de solution applicative\",\n" +
            "      \"imgUrl\": \"https://media.licdn.com/dms/image/C4E03AQHnCm7ppInfEg/profile-displayphoto-shrink_800_800/0/1657488652579?e=1684368000&v=beta&t=1sz-8tJgcsQmZaV7o3aXYAWQAYqSKO8NOYJbzi2sTPA\"\n" +
            "    },\n" +

            "    {\n" +
            "      \"name\": \"Thibault\",\n" +
            "      \"email\": \"thibault@epsi.fr\",\n" +
            "      \"group\": \"Groupe Dev1\",\n" +
            "      \"description\": \"Étudiant en troisième année à l’EPSI parcours bachelor concepteur développeur de solution applicative\",\n" +
            "      \"imgUrl\": \"https://media.licdn.com/dms/image/C4E03AQHnCm7ppInfEg/profile-displayphoto-shrink_800_800/0/1657488652579?e=1684368000&v=beta&t=1sz-8tJgcsQmZaV7o3aXYAWQAYqSKO8NOYJbzi2sTPA\"\n" +
            "    },\n" +

            "    {\n" +
            "      \"name\": \"Tom\",\n" +
            "      \"email\": \"Tom@epsi.fr\",\n" +
            "      \"group\": \"Groupe Dev2\",\n" +
            "      \"description\": \"Étudiant en troisième année à l’EPSI parcours bachelor concepteur développeur de solution applicative\",\n" +
            "      \"imgUrl\": \"https://media.licdn.com/dms/image/C4E03AQHnCm7ppInfEg/profile-displayphoto-shrink_800_800/0/1657488652579?e=1684368000&v=beta&t=1sz-8tJgcsQmZaV7o3aXYAWQAYqSKO8NOYJbzi2sTPA\"\n" +
            "    },\n" +

            "    {\n" +
            "      \"name\": \"Alexis\",\n" +
            "      \"email\": \"alexis@epsi.fr\",\n" +
            "      \"group\": \"Groupe Dev2\",\n" +
            "      \"description\": \"Étudiant en troisième année à l’EPSI parcours bachelor concepteur développeur de solution applicative\",\n" +
            "      \"imgUrl\": \"https://media.licdn.com/dms/image/C4E03AQHnCm7ppInfEg/profile-displayphoto-shrink_800_800/0/1657488652579?e=1684368000&v=beta&t=1sz-8tJgcsQmZaV7o3aXYAWQAYqSKO8NOYJbzi2sTPA\"\n" +
            "    },\n" +

            "    {\n" +
            "      \"name\": \"Jules\",\n" +
            "      \"email\": \"jules@epsi.fr\",\n" +
            "      \"group\": \"Groupe Dev2\",\n" +
            "      \"description\": \"Étudiant en troisième année à l’EPSI parcours bachelor concepteur développeur de solution applicative\",\n" +
            "      \"imgUrl\": \"https://media.licdn.com/dms/image/C4E03AQHnCm7ppInfEg/profile-displayphoto-shrink_800_800/0/1657488652579?e=1684368000&v=beta&t=1sz-8tJgcsQmZaV7o3aXYAWQAYqSKO8NOYJbzi2sTPA\"\n" +
            "    }\n" +

            "  ]\n" +
            "}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)
        showBack()
        setHeaderTitle(getString(R.string.title_students))

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

        val recyclerviewStudents=findViewById<RecyclerView>(R.id.recyclerview)
        recyclerviewStudents.layoutManager=LinearLayoutManager(this)
        val studentAdapter=StudentAdapter(students)
        recyclerviewStudents.adapter=studentAdapter
    }
}