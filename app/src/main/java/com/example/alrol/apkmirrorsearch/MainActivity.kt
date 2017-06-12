package com.example.alrol.apkmirrorsearch

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*

var searchString = ""
var searchFor = ""
var searchInput = ""

class MainActivity : Activity() {
    lateinit var searchUrl : String
    lateinit var searchField: SearchView
    lateinit var searchButton: Button
    lateinit var radioApk : RadioButton
    lateinit var radioApp : RadioButton
    lateinit var radioDev : RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton = findViewById(R.id.search_button) as Button
        searchField = findViewById(R.id.search) as SearchView
        radioApk = findViewById(R.id.apk_radio_button) as RadioButton
        radioApp = findViewById(R.id.app_radio_button) as RadioButton
        radioDev = findViewById(R.id.dev_radio_button) as RadioButton


    }


    fun sendSearch (view: View) {

        if (radioApk.isChecked) {
            searchUrl = "http://www.apkmirror.com/?post_type=app_release&searchtype=apk&s="
            searchFor = "apk"
        }
        if (radioApp.isChecked) {
            searchUrl = "http://www.apkmirror.com/?post_type=app_release&searchtype=app&s="
            searchFor = "app"
        }
        if (radioDev.isChecked) {
            searchUrl = "http://www.apkmirror.com/?post_type=app_release&searchtype=dev&s="
            searchFor = "dev"
        }

        searchInput = searchField.query.toString()
        searchString = searchUrl+searchInput

        if (searchInput != "") {
            val webViewActivityIntent = Intent(this, WebViewActivity::class.java)
            startActivity(webViewActivityIntent)
        } else {
            searchField.setBackgroundColor(Color.RED)
        }


    }



}
