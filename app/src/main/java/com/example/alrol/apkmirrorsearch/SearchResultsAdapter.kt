package com.example.alrol.apkmirrorsearch

import android.content.Context
import android.provider.Telephony
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList
import android.widget.TextView


/**
 * Created by alrol on 2017-06-21.
 */
class SearchResultsAdapter(searchResults: ArrayList<AppInfo>): RecyclerView.Adapter<SearchResultsAdapter.SearchResultsViewHolder>() {

    lateinit var searchResults: ArrayList<AppInfo>

    fun SearchResultsAdapter(searchResults: ArrayList<AppInfo>) {
        this.searchResults = searchResults

    }

    class SearchResultsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var appNameText = view.findViewById(R.id.appName) as TextView
        var appDevText = view.findViewById(R.id.appDev) as TextView
//        var appUploadedDateText = view.findViewById(R.id.appUploadedDate) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsAdapter.SearchResultsViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.search_results_row, parent, false)

        return SearchResultsViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: SearchResultsViewHolder, position: Int) {
//        var data = ArrayList<AppInfo>()
//
//        var app1 = AppInfo("TITLE 1","DEV1","","","",69,"")
//        var app2 = AppInfo("TITLE 2","DEV2","","","",96,"")
//
//        data.add(app1)
//        data.add(app2)

        var app = searchResultArray[position]
        holder.appNameText.text = app.title
        holder.appDevText.text = app.dev
//        holder.appUploadedDateText.text = app.dateUploaded
    }

    override fun getItemCount(): Int {
        return searchResultArray.size
    }



}