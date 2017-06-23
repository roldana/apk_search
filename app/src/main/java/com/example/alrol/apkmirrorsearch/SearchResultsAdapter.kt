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
class SearchResultsAdapter(val searchResults: ArrayList<AppInfo>): RecyclerView.Adapter<SearchResultsAdapter.SearchResultsViewHolder>() {

//    lateinit var searchResults: ArrayList<AppInfo>
////
//    fun SearchResultsAdapter(searchResults: ArrayList<AppInfo>) {
//        this.searchResults = searchresult
//    }

    class SearchResultsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var appNameText = view.findViewById(R.id.appName) as TextView
        var appDevText = view.findViewById(R.id.appDev) as TextView
        var appUploadedDateText = view.findViewById(R.id.appUploadedDate) as TextView
        var appDownloadNumberText = view.findViewById(R.id.appDownloadNumber) as TextView
        var appSizeText = view.findViewById(R.id.appSize) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsAdapter.SearchResultsViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.search_results_row, parent, false)

        return SearchResultsViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: SearchResultsViewHolder, position: Int) {

        var app = searchResults[position]
        holder.appNameText.text = app.title
        holder.appDevText.text = app.dev
        holder.appUploadedDateText.text = app.dateUploaded
        holder.appSizeText.text = app.fileSize
        holder.appDownloadNumberText.text = app.downloads.toString()

    }

    override fun getItemCount(): Int {
        return searchResults.size
    }



}