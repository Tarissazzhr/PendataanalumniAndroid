package com.example.utsprojek

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.utsprojek.DataBerita

class AdapterBerita(
    context: Context,
    resource: Int,
    items: List<DataBerita>
) : ArrayAdapter<DataBerita>(context, resource, items) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val resource = resource

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder: Holder
        val view: View

        if (convertView == null) {
            holder = Holder()
            view = inflater.inflate(resource, parent, false)
            holder.imageView = view.findViewById(R.id.imageView)
            holder.txtTitle = view.findViewById(R.id.txtTitle)
            holder.txtDesc = view.findViewById(R.id.txtDesc)
            view.tag = holder
        } else {
            holder = convertView.tag as Holder
            view = convertView
        }

        val dataBerita = getItem(position)
        holder.txtTitle.text = dataBerita?.title
        holder.txtDesc.text = dataBerita?.descDetail
        Glide.with(context).load(dataBerita?.imageUrl).into(holder.imageView)

        return view
    }

    private class Holder {
        lateinit var imageView: ImageView
        lateinit var txtTitle: TextView
        lateinit var txtDesc: TextView
    }
}