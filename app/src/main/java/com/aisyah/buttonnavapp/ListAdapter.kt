package com.aisyah.buttonnavapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.listitem.view.*

class ListAdapter(private val listdata: ArrayList<Model>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: Model) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(model.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item)
                name_item.text = model.name
                desc_item.text = model.desc
            }

            itemView.setOnClickListener {
                val i = Intent(itemView.context.applicationContext, DetailActivity::class.java)
                i.putExtra("extra_item", model)
                itemView.context.startActivity(i)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, position: Int) {
        holder.bind(listdata[position])
    }
}