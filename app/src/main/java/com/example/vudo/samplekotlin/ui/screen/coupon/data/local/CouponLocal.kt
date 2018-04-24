package com.example.vudo.samplekotlin.ui.screen.coupon.data.local

import com.example.vudo.samplekotlin.model.BaseEntity
import com.example.vudo.samplekotlin.model.Coupon
import com.example.vudo.samplekotlin.ui.screen.coupon.data.CouponDataSource
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vu.do on 4/18/2018.
 */
class CouponLocal @Inject constructor(): CouponDataSource {

    override fun getCoupons(): Observable<BaseEntity<List<Coupon>>> {
        throw UnsupportedOperationException("getCoupons is not used in local now")
    }
}