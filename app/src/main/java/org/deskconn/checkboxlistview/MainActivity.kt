package org.deskconn.checkboxlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.deskconn.checkboxlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var personArrayList: ArrayList<PersonDataClass>

    private var hashMap: MutableMap<Int, Any> = HashMap()
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
            hashMap[i] = isOdd(i)
            val person = PersonDataClass(personName[i], personDesignation[i], personImageId[i], true)
            personArrayList.add(person)
        }

        Log.e("TAG", " map $hashMap")

        binding.listView.isClickable = true
        binding.listView.adapter = PersonAdapterClass(this, personArrayList, hashMap)
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val personName = personName[position]
            val personDesignation = personDesignation[position]
            val personImageId = personImageId[position]
        }
    }

    private fun isOdd(`val`: Int): Boolean {
        return `val` and 0x01 == 0
    }

}