package com.example.speedtracks
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.TextView


class ShoeAdapter(private val context: Activity,private val arrayList: ArrayList<UserShoes>): ArrayAdapter<UserShoes>(context, R.layout.list_view,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_view, null)
        val shoe: TextView = view.findViewById(R.id.shoeID)
        val progress: ProgressBar = view.findViewById(R.id.progressID)
        shoe.text = arrayList[position].shoeName
        progress.progress = arrayList[position].usage
        return super.getView(position, convertView, parent)
    }
}