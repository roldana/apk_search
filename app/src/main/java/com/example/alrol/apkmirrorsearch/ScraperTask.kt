package com.example.alrol.apkmirrorsearch

import android.os.AsyncTask
import android.util.Log
import org.jsoup.Jsoup

/**
 * Created by alrol on 2017-06-23.
 */
class ScraperTask:  AsyncTask<String, Int, ArrayList<AppInfo>>() {

    lateinit var delegate: ScraperFragment

    override fun doInBackground(vararg params: String?): ArrayList<AppInfo> {

        var results = ArrayList<AppInfo>()

        try {
            var jsoupDoc = Jsoup.connect(searchString).get()
            var resultsPage = jsoupDoc.getElementsByClass("listWidget")[0]
            var apps = resultsPage.getElementsByClass("appRow")
//            var numberOfResults = apps.size
            var appsInfo = resultsPage.getElementsByClass("infoSlide")

            if (apps.size > 0) {
                for (i in apps.indices) {
                    var appTitle = apps[i].getElementsByClass("fontBlack").text()
                    var appImgLink = apps[i].getElementsByTag("img").attr("src")
                    var appDev = apps[i].getElementsByClass("byDeveloper")[0].text()
                    var appDate = apps[i].getElementsByClass("dateyear_utc")[0].text()
                    var appUrl = apps[i].getElementsByClass("downloadLink").attr("href")
                    var appSize = appsInfo[i].getElementsByClass("infoslide-value")[2].text()
                    var appNumDownloads = appsInfo[i].getElementsByClass("infoslide-value")[3].text()
                    results.add(AppInfo(appTitle, appDev, appDate, "", appSize, appNumDownloads, appUrl))
                }
            } else {
                results.add(AppInfo("NO APPS FOUND","", "", "", "", "", ""))
            }


        } catch (e: Exception) {
            Log.d("Exception: ", e.toString())
        }
        return results
    }

    override fun onPostExecute(result: ArrayList<AppInfo>) {

        Log.d("Scraper: ", "done")
        delegate.processFinish(result)

    }

}