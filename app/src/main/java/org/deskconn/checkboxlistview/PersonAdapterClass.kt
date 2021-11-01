package org.deskconn.checkboxlistview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

class PersonAdapterClass(
    private val context: Activity,
    private val arrayList: ArrayList<PersonDataClass>,
    private val hashMap: MutableMap<Int, Any>
):
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
        //checkBox.isChecked = arrayList[position].checkBox
        checkBox.isChecked = hashMap[position] as Boolean

        checkBox.setOnCheckedChangeListener { buttonView, checked: Boolean ->
            hashMap[position] = checked
            println("Map Position: ${hashMap[position]}")
        }
        return view
    }
}