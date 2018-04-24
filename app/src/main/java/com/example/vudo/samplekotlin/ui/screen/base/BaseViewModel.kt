package com.example.vudo.samplekotlin.ui.screen.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by vu.do on 4/18/2018.
 */
open class BaseViewModel<V> : ViewModel(), LifecycleObserver {

    private val disposable : CompositeDisposable = CompositeDisposable()
    private var mNavigator: V? = null

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun getCompositeDisposable() : CompositeDisposable = disposable

    fun getNavigator(): V? {
        return mNavigator
    }

    fun setNavigator(navigator : V) {
        mNavigator = navigator
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate(){}
}