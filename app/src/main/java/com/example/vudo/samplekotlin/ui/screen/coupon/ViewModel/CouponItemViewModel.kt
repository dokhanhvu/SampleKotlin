package com.example.vudo.samplekotlin.ui.screen.coupon.ViewModel

import android.databinding.ObservableField
import com.example.vudo.samplekotlin.model.Coupon
import com.example.vudo.samplekotlin.ui.screen.base.BaseViewModel
import com.example.vudo.samplekotlin.ui.screen.coupon.CouponItemNavigator

/**
 * Created by vu.do on 4/19/2018.
 */
class CouponItemViewModel constructor(private val coupon : Coupon): BaseViewModel<CouponItemNavigator>() {

    lateinit var content: ObservableField<String>

    lateinit var imageUrl: ObservableField<String>

    lateinit var deal: ObservableField<String>

    lateinit var name: ObservableField<String>

    lateinit var detail: ObservableField<String>

    lateinit var category: ObservableField<String>

    private fun bind(){
        imageUrl = ObservableField(coupon.cover)
        content = ObservableField(coupon.content)
        deal = ObservableField("-" + coupon.deal + "%")
        name = ObservableField(coupon.name)
        detail = ObservableField(coupon.detail)
        category = ObservableField(coupon.category)
    }

    override fun onCreate() {
        super.onCreate()
        //coupon = getNavigator()?.provideCoupon()
        bind()
    }

    fun onDetailClick(){
        getNavigator()?.openDetailCoupon()
    }

}