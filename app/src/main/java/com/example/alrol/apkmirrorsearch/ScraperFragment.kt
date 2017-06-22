package com.example.alrol.apkmirrorsearch

import android.app.Activity
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class ScraperFragment : Activity() {

    lateinit var searchResultsRV: RecyclerView
    lateinit var searchResultsRVAdapter: SearchResultsAdapter
    lateinit var searchResultsRVLayoutManager: RecyclerView.LayoutManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scraper_fragment)
        searchResultsRV = findViewById(R.id.searchResultsRecyclerView) as RecyclerView
        title = "$searchFor: $searchInput"

        searchResultsRVLayoutManager = LinearLayoutManager(this)
        searchResultsRV.layoutManager = searchResultsRVLayoutManager

        searchResultsRVAdapter = SearchResultsAdapter(searchResultArray)
        searchResultsRV.adapter = searchResultsRVAdapter



    }

    fun refresh(){
        searchResultsRV.adapter.notifyDataSetChanged()
    }



}
