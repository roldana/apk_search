package com.example.alrol.apkmirrorsearch

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.content.IntentFilter
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.webkit.WebView
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory


class WebViewActivity : Activity() {

    lateinit var webview: WebView
    lateinit var br: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        title = "$searchFor: $searchInput"

        webview = findViewById(R.id.searchWebView)
        webview.settings.javaScriptEnabled = true
        webview.loadUrl(searchString)




//        BROADCAST:
//        class myBroadcastReceiver : BroadcastReceiver() {
//            private val TAG = "MyBroadcastReceiver"
//            override fun onReceive (context: Context, intent: Intent){
//                Log.d("BROADCAST", "RECEIVED")
//            }
//        }
//        br = myBroadcastReceiver()
//        var complete = IntentFilter()
//        this.registerReceiver(br, complete)



    }
}
