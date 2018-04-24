package com.example.vudo.samplekotlin.provider.scheduler

import io.reactivex.ObservableTransformer

/**
 * Created by vu.do on 4/24/2018.
 */
interface SchedulerProvider {

    fun <T> observableComputationScheduler() : ObservableTransformer<T, T>

    fun <T> observableIOScheduler() : ObservableTransformer<T, T>

}