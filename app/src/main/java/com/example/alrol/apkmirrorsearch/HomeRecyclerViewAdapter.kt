package com.example.alrol.apkmirrorsearch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.util.ArrayList
import android.widget.TextView
import com.squareup.picasso.Picasso


/**
 * Created by alrol on 2017-06-21.
 */
class HomeRecyclerViewAdapter(val results: ArrayList<AppInfo>): RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder>() {

    class HomeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        var appNameText: TextView = view.findViewById(R.id.appName)
        var appDownloadNumberText: TextView = view.findViewById(R.id.appDownloadNumber)
        var appImage: ImageView = view.findViewById(R.id.appImg)


        fun setOnClick(item: AppInfo){
            appNameText.setOnClickListener{
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                ContextCompat.startActivity(view.context, browserIntent, Bundle())

            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewAdapter.HomeViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.home_recyclerview_row, parent, false)

        return HomeViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        var app = results[position]

        holder.setOnClick(app)

        Picasso.with(holder.appImage.context).load(app.imageUrl).into(holder.appImage)


        holder.appNameText.text = app.title
        holder.appDownloadNumberText.text = app.downloads

    }

    override fun getItemCount(): Int {
        return results.size
    }



}