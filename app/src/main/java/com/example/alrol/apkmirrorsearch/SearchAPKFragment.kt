package com.example.alrol.apkmirrorsearch

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import android.widget.ProgressBar


class SearchAPKFragment : Activity(), AsyncResponse {

    lateinit var searchResultsRV: RecyclerView
    lateinit var searchResultsRVAdapter: SearchResultsAdapter
    lateinit var searchResultsRVLayoutManager: RecyclerView.LayoutManager
    lateinit var progressBar: ProgressBar
    var scraper = SearchScraperTask()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_results_apk_fragment)
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

//        searchResultsRV.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

        progressBar.visibility = View.GONE
    }

    override fun linkReady(link: String) {
    }

}


