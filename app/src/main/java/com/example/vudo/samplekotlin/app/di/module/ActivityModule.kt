package com.example.vudo.samplekotlin.app.di.module

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.vudo.samplekotlin.app.di.qualifier.ForNonApplication
import com.example.vudo.samplekotlin.app.di.scope.PerNonApplication
import dagger.Module
import dagger.Provides

/**
 * Created by vu.do on 4/19/2018.
 */
@Module
class ActivityModule constructor(private val mActivity : AppCompatActivity){

    @Provides
    @PerNonApplication
    @ForNonApplication
    fun provideContext() : Context = mActivity

    @Provides
    @PerNonApplication
    @ForNonApplication
    fun provideActivity() : AppCompatActivity = mActivity

    @Provides
    @PerNonApplication
    fun provideSupportFragmentManager() : FragmentManager = mActivity.supportFragmentManager
}