package com.example.vudo.samplekotlin.ui.screen.coupon.data

import com.example.vudo.samplekotlin.model.BaseEntity
import com.example.vudo.samplekotlin.model.Coupon
import com.example.vudo.samplekotlin.ui.screen.coupon.data.local.CouponLocal
import com.example.vudo.samplekotlin.ui.screen.coupon.data.remote.CouponRemote
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by vu.do on 4/18/2018.
 */
class CouponRepositoryImpl @Inject constructor(private val couponDataSourceRemote : CouponRemote, private val couponDataSourceLocal : CouponLocal): CouponDataSource{

    override fun getCoupons(): Observable<BaseEntity<List<Coupon>>> {
        return couponDataSourceRemote.getCoupons()
    }

}