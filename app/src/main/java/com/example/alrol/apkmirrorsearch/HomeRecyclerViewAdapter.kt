package com.example.alrol.apkmirrorsearch

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList
import android.widget.TextView


/**
 * Created by alrol on 2017-06-21.
 */
class HomeRecyclerViewAdapter(val results: ArrayList<AppInfo>): RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder>() {

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var appNameText = view.findViewById(R.id.appName) as TextView
        var appDownloadNumberText = view.findViewById(R.id.appDownloadNumber) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewAdapter.HomeViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.home_recyclerview_row, parent, false)

        return HomeViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        var app = results[position]
        holder.appNameText.text = app.title
        holder.appDownloadNumberText.text = app.downloads

    }

    override fun getItemCount(): Int {
        return results.size
    }



}