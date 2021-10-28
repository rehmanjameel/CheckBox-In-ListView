package org.deskconn.checkboxlistview

import android.app.Activity
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class PersonAdapterClass(private val context: Activity, private val arrayList: ArrayList<PersonDataClass>):
    ArrayAdapter<PersonDataClass>(context, R.layout.list_items, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_items, null)

        val personName = view.findViewById<TextView>(R.id.personName)
        val personDesignation = view.findViewById<TextView>(R.id.personDesignation)
        val personImageId = view.findViewById<ImageView>(R.id.profilePic)
        val checkBox = view.findViewById<CheckBox>(R.id.checkBoxId)



        personName.text = arrayList[position].personName
        personDesignation.text = arrayList[position].personDesignation
        personImageId.setImageResource(arrayList[position].personImageId)

        return view
    }
}