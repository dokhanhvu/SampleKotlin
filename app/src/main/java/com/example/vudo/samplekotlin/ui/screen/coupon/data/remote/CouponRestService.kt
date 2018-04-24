package com.example.vudo.samplekotlin.ui.screen.coupon.data.remote

import com.example.vudo.samplekotlin.model.BaseEntity
import com.example.vudo.samplekotlin.model.Coupon
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by vu.do on 4/18/2018.
 */
interface CouponRestService {

    @GET("getCoupons.json")
    fun getCoupons() : Observable<BaseEntity<List<Coupon>>>

}