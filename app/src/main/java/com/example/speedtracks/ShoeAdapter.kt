package com.example.speedtracks
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class ShoeAdapter(context: Context,private val arrayList: ArrayList<UserShoes>) : ArrayAdapter<UserShoes>(context, R.layout.list_item, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item, null)
       // val shoe: TextView = view.findViewById(R.id.shoeID)
        //val progress: TextView = view.findViewById(R.id.progressID)
       // shoe.text = arrayList[position].shoeName
       // progress.text = arrayList[position].usage
        return super.getView(position, convertView, parent)
    }
}