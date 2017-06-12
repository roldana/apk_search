package com.example.alrol.apkmirrorsearch

import android.app.Activity
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import java.io.File
import kotlin.coroutines.experimental.EmptyCoroutineContext.plus


class WebViewActivity : Activity() {

    lateinit var webview: WebView
    lateinit var br: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        title = "$searchFor: $searchInput"

        webview = findViewById(R.id.searchWebView) as WebView

        webview.settings.javaScriptEnabled = true
        webview.settings.allowFileAccess = true
        webview.settings.allowContentAccess = true
        webview.settings.allowFileAccessFromFileURLs = true

        webview.loadUrl(searchString)
//
//        var downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//        var file = File(applicationContext.filesDir, "testpdf.pdf")
//
////        var exists_bef = file.exists()
////        var output = filesDir.outputStream()
////        output = openFileOutput("testpdf,pdf", Context.MODE_PRIVATE)
////        output.write()
////        var exists_after = file.exists()
//
//        var filesdir = applicationContext.filesDir.toString()
//
//
//        var downloadRequest = DownloadManager.Request(Uri.parse("http://www.pdf995.com/samples/pdf.pdf"))
//        var down_id = downloadManager.enqueue(downloadRequest)
//
//
////        downloadManager.addCompletedDownload("PDF download","PDF download description", true, "application/pdf", down_uri.toString(),Long(),true)
//
//
//        class myBroadcastReceiver : BroadcastReceiver() {
//            private val TAG = "MyBroadcastReceiver"
//            override fun onReceive (context: Context, intent: Intent){
//                Log.d("BROADCAST", "RECEIVED")
////                var down_uri = downloadManager.getUriForDownloadedFile(down_id)
//                var file_string = context.filesDir
//                downloadManager.openDownloadedFile(down_id)
//
////                var pdfintent = Intent(Intent.ACTION_VIEW).setDataAndType(Uri.parse("https://bitcoin.org/bitcoin.pdf"), "application/pdf")
////                var pdfintent = Intent(Intent.ACTION_VIEW, Uri.parse("/data/user/0/com.example.alrol.apkmirrorsearch/files/pdf.pdf"))
////                pdfintent.type = "application/pdf"
//
////                startActivity(pdfintent)
//
//            }
//        }
//
//        br = myBroadcastReceiver()
//        var complete = IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
//        this.registerReceiver(br, complete)


//        webview.loadData("https://bitcoin.org/bitcoin.pdf", "document/pdf", "UTF-8")


    }
}
