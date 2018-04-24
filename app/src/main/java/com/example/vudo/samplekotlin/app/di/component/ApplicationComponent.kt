package com.example.vudo.samplekotlin.app.di.component

import android.app.Application
import android.content.Context
import com.example.vudo.samplekotlin.app.KotlinSampleApplication
import com.example.vudo.samplekotlin.app.di.module.ApplicationModule
import com.example.vudo.samplekotlin.app.di.qualifier.ForApplication
import com.example.vudo.samplekotlin.app.di.scope.PerApplication
import com.google.gson.Gson
import dagger.Component
import okhttp3.OkHttpClient

/**
 * Created by vu.do on 4/17/2018.
 */
@PerApplication
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(myApp : KotlinSampleApplication)

    fun getApplication() : Application

    @ForApplication
    fun getContext(): Context

    fun getGson(): Gson

    fun getOKHttpClient() : OkHttpClient

}