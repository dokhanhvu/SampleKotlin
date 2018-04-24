package com.example.vudo.samplekotlin.ui.screen.coupon.data

import com.example.vudo.samplekotlin.model.BaseEntity
import com.example.vudo.samplekotlin.model.Coupon
import io.reactivex.Observable

/**
 * Created by vu.do on 4/18/2018.
 */
interface CouponDataSource {

    fun getCoupons() : Observable<BaseEntity<List<Coupon>>>

}