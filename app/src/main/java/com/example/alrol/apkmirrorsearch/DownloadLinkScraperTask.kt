package com.example.alrol.apkmirrorsearch

import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import org.jsoup.Jsoup

/**
 * Created by alrol on 2017-06-23.
 */
class DownloadLinkScraperTask:  AsyncTask<String, Int, String>() {

    lateinit var delegate: SearchResultsAdapter.SearchResultsViewHolder

    override fun doInBackground(vararg params: String?): String {

        var downloadLink = ""

        try {
            var jsoupDoc = Jsoup.connect(params[0]).get()
            var buttonText = jsoupDoc.getElementsByClass("downloadButton").text()

            if (buttonText == "See available APKs"){
                var downloadsList = jsoupDoc.getElementsByClass("listWidget")[0]
                var firstDownloadLink = downloadsList.getElementsByTag("a")[1].attr("href")
                var downloadPage = "https://www.apkmirror.com" + firstDownloadLink
                var jsoupDoc2 = Jsoup.connect(downloadPage).get()
                var downloadButtonLink = jsoupDoc2.getElementsByClass("downloadButton").attr("href")
                if (downloadButtonLink.startsWith("/apk")){
                    var jsoupDoc3 = Jsoup.connect("https://www.apkmirror.com" + downloadButtonLink).get()
                    var downloadParagraph = jsoupDoc3.getElementsByClass("notes")[1]
                    var downloadLinkDirect = downloadParagraph.getElementsByTag("a").attr("href")
                    downloadLink = "https://www.apkmirror.com" + downloadLinkDirect
                } else {
                    downloadLink = "https://www.apkmirror.com" + downloadButtonLink
                }
            } else if (buttonText == "Download APK"){
                var downloadButtonLink = jsoupDoc.getElementsByClass("downloadButton").attr("href")
                if (downloadButtonLink.startsWith("/apk")) {
                    var jsoupDoc4 = Jsoup.connect("https://www.apkmirror.com" +downloadButtonLink).get()
                    var downloadParagraph = jsoupDoc4.getElementsByClass("notes")[1]
                    var downloadLinkDirect = downloadParagraph.getElementsByTag("a").attr("href")
                    downloadLink = "https://www.apkmirror.com" + downloadLinkDirect

                } else {
                    downloadLink = "https://www.apkmirror.com" + downloadButtonLink

                }
            } else {
                downloadLink = "Scraper broken"
            }

        } catch (e: Exception) {
            Log.d("DL Scraper exception: ", e.toString())
        }
        return downloadLink
    }

    override fun onPostExecute(downloadLink: String) {

        Log.d("DL Link Scraper: ", "done")
        delegate.linkReady(downloadLink)

    }

}