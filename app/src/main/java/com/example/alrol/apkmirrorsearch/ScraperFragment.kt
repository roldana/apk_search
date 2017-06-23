package com.example.alrol.apkmirrorsearch

import android.app.Activity
import android.content.Context
import android.opengl.Visibility
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import android.os.AsyncTask.execute
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import android.widget.ProgressBar


class ScraperFragment : Activity(), AsyncResponse {

    lateinit var searchResultsRV: RecyclerView
    lateinit var searchResultsRVAdapter: SearchResultsAdapter
    lateinit var searchResultsRVLayoutManager: RecyclerView.LayoutManager
    lateinit var progressBar: ProgressBar
    var scraper = SearchScraperTask()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scraper_fragment)
        title = "$searchFor: $searchInput"


        searchResultsRV = findViewById(R.id.searchResultsRecyclerView) as RecyclerView
        progressBar = findViewById(R.id.scraperProgress) as ProgressBar

        scraper.delegate = this
        scraper.execute(searchString)


    }

    override fun processFinish(result: ArrayList<AppInfo>){

        searchResultArray = result

        searchResultsRVLayoutManager = LinearLayoutManager(this)
        searchResultsRV.layoutManager = searchResultsRVLayoutManager

        searchResultsRVAdapter = SearchResultsAdapter(result)
        searchResultsRV.adapter = searchResultsRVAdapter

        searchResultsRV.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

        progressBar.visibility = View.GONE
    }

    fun setProgressPercent(vararg progress: Int?){
        progressBar.progress = progress[0] as Int
    }

}


