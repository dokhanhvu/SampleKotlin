package com.example.vudo.samplekotlin.ui.screen.coupon.data.remote

import com.example.vudo.samplekotlin.BuildConfig
import com.example.vudo.samplekotlin.model.BaseEntity
import com.example.vudo.samplekotlin.model.Coupon
import com.example.vudo.samplekotlin.provider.network.NetworkProviderImpl
import com.example.vudo.samplekotlin.ui.screen.coupon.data.CouponDataSource
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vu.do on 4/18/2018.
 */

class CouponRemote @Inject constructor(private val networkProvider : NetworkProviderImpl) : CouponDataSource{

    override fun getCoupons(): Observable<BaseEntity<List<Coupon>>> {
        var observable : Observable<BaseEntity<List<Coupon>>> = networkProvider.makeRequest(
                networkProvider.provideApi(BuildConfig.TEST_URL, CouponRestService::class.java)
                        .getCoupons()
        )

        return observable
    }
}
