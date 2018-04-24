package com.example.vudo.samplekotlin.provider.network

import android.content.Context
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by vu.do on 4/17/2018.
 */
interface NetworkProvider {

    fun isNetworkAvailable() : Boolean

    fun <T> provideApi(url : String, service : Class<T>) : T

    fun <Response> makeRequest(observable: Observable<Response>) : Observable<Response>

}