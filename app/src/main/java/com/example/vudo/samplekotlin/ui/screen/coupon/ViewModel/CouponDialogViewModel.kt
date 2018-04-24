package com.example.vudo.samplekotlin.ui.screen.coupon.ViewModel

import android.databinding.ObservableField
import butterknife.BindColor
import com.example.vudo.samplekotlin.R
import com.example.vudo.samplekotlin.model.Coupon
import com.example.vudo.samplekotlin.ui.screen.base.BaseViewModel
import com.example.vudo.samplekotlin.ui.screen.coupon.CouponDialogNavigator
import lt.neworld.spanner.Spanner
import lt.neworld.spanner.Spans.foreground

/**
 * Created by vu.do on 4/24/2018.
 */
class CouponDialogViewModel constructor(private val coupon : Coupon): BaseViewModel<CouponDialogNavigator>() {

    lateinit var name : ObservableField<String>

    lateinit var shopName : ObservableField<String>

    lateinit var content : ObservableField<String>

    lateinit var detail : ObservableField<String>

    lateinit var campaign : ObservableField<String>

    lateinit var deal : ObservableField<String>

    @BindColor(R.color.colorCinnabar)
    var campaignColor: Int = 0

    private fun bind(){
        name = ObservableField(coupon.name)
        shopName = ObservableField(coupon.shopName)
        content = ObservableField(coupon.content)
        detail = ObservableField(coupon.detail)
        campaign = ObservableField(Spanner().append("${coupon.startDate} - ${coupon.endDate}", foreground(campaignColor)).toString())
        deal = ObservableField(Spanner().append("-${coupon.deal}%", foreground(campaignColor)).toString())
    }

    fun onCancelClick()
    {
        getNavigator()?.dismissDialog()
    }

    override fun onCreate() {
        super.onCreate()
        bind()
    }

}