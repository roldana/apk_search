package com.example.alrol.apkmirrorsearch

import android.app.Activity
import android.content.Context
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


class ScraperFragment : Activity(), AsyncResponse {

    lateinit var searchResultsRV: RecyclerView
    lateinit var searchResultsRVAdapter: SearchResultsAdapter
    lateinit var searchResultsRVLayoutManager: RecyclerView.LayoutManager
    var scraper = ScraperTask()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scraper_fragment)
        searchResultsRV = findViewById(R.id.searchResultsRecyclerView) as RecyclerView
        title = "$searchFor: $searchInput"

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
    }

}


