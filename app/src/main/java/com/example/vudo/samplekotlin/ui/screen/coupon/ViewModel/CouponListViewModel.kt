package com.example.vudo.samplekotlin.ui.screen.coupon.ViewModel

import com.example.vudo.samplekotlin.model.BaseEntity
import com.example.vudo.samplekotlin.model.Coupon
import com.example.vudo.samplekotlin.ui.screen.base.BaseViewModel
import com.example.vudo.samplekotlin.ui.screen.coupon.CouponListNavigator
import com.example.vudo.samplekotlin.ui.screen.coupon.data.CouponDataSource
import com.example.vudo.samplekotlin.ui.screen.coupon.data.CouponRepositoryImpl
import com.example.vudo.samplekotlin.ui.screen.coupon.view.FragmentPagerAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by vu.do on 4/18/2018.
 */
class CouponListViewModel () : BaseViewModel<CouponListNavigator>() {

    lateinit var dataSource: CouponDataSource

    lateinit var adapter : FragmentPagerAdapter

    @Inject
    constructor(couponRepository : CouponRepositoryImpl) : this(){
        this.dataSource = couponRepository
    }

    fun getCoupons(){
        getCompositeDisposable().add(
                dataSource.getCoupons()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe { _: Disposable? ->  }
                        .doOnTerminate {  }
                        .subscribe({t: BaseEntity<List<Coupon>> ->
                            getNavigator()?.getCouponSuccessfully(t.data)
                        }, {t: Throwable ->
                            getNavigator()?.getCouponFailed(t)
                        })
        )
    }

    override fun onCreate() {
        super.onCreate()

    }
}