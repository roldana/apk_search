package com.example.alrol.apkmirrorsearch

/**
 * Created by alrol on 2017-06-23.
 */
interface AsyncResponse {
    fun processFinish(output: ArrayList<AppInfo>)
    fun linkReady(link: String)
}