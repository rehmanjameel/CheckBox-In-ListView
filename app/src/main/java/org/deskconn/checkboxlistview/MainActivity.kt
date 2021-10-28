package org.deskconn.checkboxlistview

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import org.deskconn.checkboxlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var personArrayList: ArrayList<PersonDataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val personImageId = intArrayOf(

            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
            R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i
        )

        val personName = arrayOf(
            "Ajmal", "Ahmad", "Wajahat", "Saddi", "Sami", "Aqdas",
            "Salman", "Tahir", "Abdul Rehman"
        )

        val personDesignation = arrayOf(
            "Android Developer", "Python Developer", "DB Developer", "Node JS Developer",
            "Node JS Developer", "Website Developer", "Website Developer", "Assistant", "Mobile App Developer"
        )

        personArrayList = ArrayList()

        for (i in personName.indices){
            val person = PersonDataClass(personName[i], personDesignation[i], personImageId[i])
            personArrayList.add(person)
        }

        binding.listView.isClickable = true
        binding.listView.adapter = PersonAdapterClass(this,personArrayList)
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val personName = personName[position]
            val personDesignation = personDesignation[position]
            val personImageId = personImageId[position]
        }
    }
}