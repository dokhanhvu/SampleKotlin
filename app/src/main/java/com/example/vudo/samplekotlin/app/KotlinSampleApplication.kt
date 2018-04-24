package com.example.vudo.samplekotlin.app

import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.example.vudo.samplekotlin.app.di.component.ApplicationComponent
import com.example.vudo.samplekotlin.app.di.component.DaggerApplicationComponent
import com.example.vudo.samplekotlin.app.di.module.ApplicationModule

/**
 * Created by vu.do on 4/17/2018.
 */
class KotlinSampleApplication : Application() {

    private var instance: KotlinSampleApplication? = null

    private var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        fun get(activity: AppCompatActivity): KotlinSampleApplication {
            return KotlinSampleApplication::class.java.cast(activity.application)
        }

        fun getInstance() : KotlinSampleApplication{
            return KotlinSampleApplication()
        }
    }

    fun getApplicationComponent() : ApplicationComponent?{
        if(mApplicationComponent == null)
            setupApplicationComponent()
        return mApplicationComponent
    }

    fun setupApplicationComponent(){
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        mApplicationComponent?.inject(this)
    }

}