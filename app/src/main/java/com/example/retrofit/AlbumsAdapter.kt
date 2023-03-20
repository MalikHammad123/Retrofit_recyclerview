package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Callback

class AlbumsAdapter(private val context: Callback<AlbumbList?>, private val items:ArrayList<AlbumbListItem>)
    :RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    class AlbumsViewHolder(item:View) : RecyclerView.ViewHolder(item){
        val text : TextView = item.findViewById(R.id.title)
        val image : ImageView  = item.findViewById(R.id.iv)
        val id : TextView  = item.findViewById(R.id.id)
        val Albumid : TextView  = item.findViewById(R.id.Albumid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return AlbumsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
       val items = items[position]
        holder.text.text = items.title
        holder.Albumid.text=items.albumId.toString()
        holder.id.text=items.id.toString()
        Glide.with(holder.image).load(items.url).into(holder.image)
    }
}