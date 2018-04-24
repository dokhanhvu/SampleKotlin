package com.example.vudo.samplekotlin.provider.scheduler

import android.os.Looper
import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by vu.do on 4/24/2018.
 */
class SchedulerProviderImpl @Inject constructor(): SchedulerProvider {

    override fun <T> observableComputationScheduler(): ObservableTransformer<T, T> {
        return ObservableTransformer{ upstream :Observable<T> ->
            upstream.subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.from(Looper.myLooper()))
        }
    }

    override fun <T> observableIOScheduler(): ObservableTransformer<T, T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}