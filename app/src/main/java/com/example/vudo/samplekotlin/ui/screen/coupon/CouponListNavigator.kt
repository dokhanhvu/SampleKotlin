package com.example.vudo.samplekotlin.ui.screen.coupon

import com.example.vudo.samplekotlin.model.Coupon

/**
 * Created by vu.do on 4/18/2018.
 */
interface CouponListNavigator {

    fun getCouponSuccessfully(coupons : List<Coupon>)

    fun getCouponFailed(throwable: Throwable)

}