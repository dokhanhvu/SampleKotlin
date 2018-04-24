package com.example.vudo.samplekotlin.provider.network

import android.content.Context
import android.net.ConnectivityManager
import com.example.vudo.samplekotlin.app.di.qualifier.ForApplication
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by vu.do on 4/17/2018.
 */
class NetworkProviderImpl @Inject constructor(@ForApplication private val context : Context,
                                              private val gson : Gson,
                                              private var okHttpClient : OkHttpClient) : NetworkProvider {

    override fun isNetworkAvailable(): Boolean {
        val connectivityManager = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override fun <T> provideApi(url: String, service: Class<T>): T {
        okHttpClient = okHttpClient.newBuilder().addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()

            requestBuilder.addHeader("Content-Type", "application/json")

            chain.proceed(requestBuilder.build())
        }.build()

        val restAdapter : Retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        return restAdapter.create(service)
    }

    override fun <Response> makeRequest(observable: Observable<Response>): Observable<Response> {
        return observable
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext { t: Throwable ->
                    if (!isNetworkAvailable()) {
                        Observable.error(Exception("Network is not available"))
                    } else Observable.error(Exception("error"))
                }
    }
}