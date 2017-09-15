package com.example.alrol.apkmirrorsearch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.util.ArrayList
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso


/**
 * Created by alrol on 2017-06-21.
 */
class SearchResultsAdapter(val searchResults: ArrayList<AppInfo>): RecyclerView.Adapter<SearchResultsAdapter.SearchResultsViewHolder>() {



    class SearchResultsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        var appNameText: TextView = view.findViewById(R.id.appName)
        var appDevText: TextView = view.findViewById(R.id.appDev)
        var appUploadedDateText: TextView = view.findViewById(R.id.appUploadedDate)
        var appDownloadNumberText: TextView = view.findViewById(R.id.appDownloadNumber)
        var appSizeText: TextView = view.findViewById(R.id.appSize)
        var appImage: ImageView = view.findViewById(R.id.appImg)

        val dlScraper = DownloadLinkScraperTask()

        fun setOnClick(item: AppInfo){
            appNameText.setOnClickListener{
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                startActivity(view.context, browserIntent, Bundle())
            }

            appImage.setOnClickListener {

                dlScraper.delegate = this
                dlScraper.execute(item.url)
            }
        }

        fun linkReady(downloadLink: String){
            val browserDownloadIntent = Intent(Intent.ACTION_VIEW, Uri.parse(downloadLink))
            startActivity(view.context, browserDownloadIntent, Bundle())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsAdapter.SearchResultsViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.search_results_row, parent, false)

        return SearchResultsViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: SearchResultsViewHolder, position: Int) {

        var app = searchResults[position]

        holder.setOnClick(app)

        Picasso.with(holder.appImage.context).load(app.imageUrl).into(holder.appImage)

        holder.appNameText.text = app.title
        holder.appDevText.text = app.dev
        holder.appUploadedDateText.text = "Uploaded: " + app.dateUploaded
        holder.appSizeText.text = app.fileSize
        holder.appDownloadNumberText.text = app.downloads + " downloads"

    }

    override fun getItemCount(): Int {
        return searchResults.size
    }



}