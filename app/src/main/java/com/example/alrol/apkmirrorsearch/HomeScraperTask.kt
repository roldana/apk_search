package com.example.alrol.apkmirrorsearch

import android.os.AsyncTask
import android.util.Log
import org.jsoup.Jsoup

/**
 * Created by alrol on 2017-06-23.
 */
class HomeScraperTask:  AsyncTask<String, Int, ArrayList<AppInfo>>() {

    lateinit var delegate: MainActivity

    override fun doInBackground(vararg params: String?): ArrayList<AppInfo> {

        var results = ArrayList<AppInfo>()

        var homeUrl = "https://www.apkmirror.com"

        try {
            var jsoupDoc = Jsoup.connect(homeUrl).get()
            var popular24Hours = jsoupDoc.getElementsByClass("listWidget")[5]
            var apps = popular24Hours.getElementsByClass("appRow")

            if (apps.size > 0) {
                for (i in apps.indices) {
                    var appTitle = apps[i].getElementsByClass("fontBlack").text()
                    var appImgUrl =  "https://www.apkmirror.com" + apps[i].getElementsByTag("img").attr("src").dropLast(16)
                    var appUrl = "https://www.apkmirror.com" + apps[i].getElementsByClass("fontBlack").attr("href")
                    var appNumDownloads = apps[i].getElementsByClass("colorLightBlack").text()
                    results.add(AppInfo(appTitle,"","","","",appNumDownloads,appUrl, appImgUrl))
                }
            } else {
                results.add(AppInfo("NO APPS FOUND","", "", "", "", "", "",""))
            }


        } catch (e: Exception) {
            Log.d("HomeScraper exception: ", e.toString())
        }
        return results
    }

    override fun onPostExecute(result: ArrayList<AppInfo>) {

        Log.d("HomeScraper: ", "done")
        delegate.processFinish(result)

    }

}