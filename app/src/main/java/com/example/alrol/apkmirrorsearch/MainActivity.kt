package com.example.alrol.apkmirrorsearch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var searchUrl : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        val searchButton = findViewById(R.id.search_button) as Button
        val searchField = findViewById(R.id.search) as SearchView
        val radioApk = findViewById(R.id.apk_radio_button) as RadioButton
        val radioApp = findViewById(R.id.app_radio_button) as RadioButton
        val radioDev = findViewById(R.id.dev_radio_button) as RadioButton



        searchButton.setOnClickListener {

            if (radioApk.isChecked) {
                searchUrl = "http://www.apkmirror.com/?post_type=app_release&searchtype=apk&s="
            }
            if (radioApp.isChecked) {
                searchUrl = "http://www.apkmirror.com/?post_type=app_release&searchtype=app&s="
            }
            if (radioDev.isChecked) {
                searchUrl = "http://www.apkmirror.com/?post_type=app_release&searchtype=dev&s="
            }
            val searchString = searchField.query

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl + searchString))
            startActivity(browserIntent)

        }

        searchField.setliste







    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


//    fun onRadioButtonClicked(view: View) {
//        // Is the button now checked?
//        val checked = (view as RadioButton).isChecked
//
//        // Check which radio button was clicked
//        when (view.getId()) {
//            R.id.apk_radio_button -> {
//                if (checked){
//                    searchUrl = "http://www.apkmirror.com/?post_type=app_release&searchtype=apk&s="
//                }
//            }
//            R.id.dev_radio_button -> {
//                if (checked) {
//                    searchUrl = "https://www.apkmirror.com/?post_type=app_release&searchtype=dev&s="
//                }
//            }
//
//            R.id.app_radio_button -> {
//                if (checked) {
//                    searchUrl = "https://www.apkmirror.com/?post_type=app_release&searchtype=app&s="
//                }
//            }
//
//        }
//    }
}
