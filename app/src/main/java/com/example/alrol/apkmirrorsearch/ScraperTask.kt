package com.example.alrol.apkmirrorsearch

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.AsyncTask
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.widget.Toast
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

/**
 * Created by alrol on 2017-06-20.
 */

class ScraperTask:  AsyncTask<String,Int,ArrayList<AppInfo>>() {

    lateinit var main: MainActivity

    override fun doInBackground(vararg params: String?): ArrayList<AppInfo> {

        var results = ArrayList<AppInfo>()

        try {
            var jsoupDoc = Jsoup.connect(searchString).get()
            var resultsPage = jsoupDoc.getElementsByClass("listWidget")[0]
            var apps = resultsPage.getElementsByClass("appRow")
            if (apps.size > 0) {
                for (app in apps) {
                    var appTitle = app.getElementsByTag("h5").attr("title")
                    var appDev = app.getElementsByClass("byDeveloper")[0].text()
                    results.add(AppInfo(appTitle, appDev, "", "", "", 69, ""))
                }
            } else {
                results.add(AppInfo("NO APPS FOUND","", "", "", "", 69, ""))
            }


        } catch (e: Exception) {
            Log.d("Exception: ", e.toString())
        }
        return results
    }

    override fun onPostExecute(result: ArrayList<AppInfo>) {

        searchResultArray = result

    }

}
