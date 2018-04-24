package com.example.vudo.samplekotlin.app.di.module

import android.app.Application
import android.content.Context
import com.example.vudo.samplekotlin.app.di.qualifier.ForApplication
import com.example.vudo.samplekotlin.app.di.scope.PerApplication
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by vu.do on 4/17/2018.
 */
@Module
class ApplicationModule constructor(private val mApplication : Application){

    @Provides
    @PerApplication
    fun provideApplication() : Application = mApplication

    @Provides
    @PerApplication
    @ForApplication
    fun provideApplicationContext() : Context = mApplication

    @Provides
    fun provideGson() : Gson{
        var gson : Gson = GsonBuilder()
                .setPrettyPrinting()
                .create()
        return gson
    }

    @Provides
    fun provideOkHttpClient() : OkHttpClient{
        var builder : OkHttpClient.Builder = OkHttpClient.Builder()

        //Set timeout
        builder.connectTimeout(120, TimeUnit.SECONDS)
        builder.readTimeout(120, TimeUnit.SECONDS)
        builder.writeTimeout(120, TimeUnit.SECONDS)

        //Enable log
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)

        return builder.build()
    }

}