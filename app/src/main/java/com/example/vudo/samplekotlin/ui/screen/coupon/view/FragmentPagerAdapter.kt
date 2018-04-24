package com.example.vudo.samplekotlin.ui.screen.coupon.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.vudo.samplekotlin.model.Coupon
import com.example.vudo.samplekotlin.ui.screen.coupon.view.CouponFragment

/**
 * Created by vu.do on 4/19/2018.
 */
class FragmentPagerAdapter(private val coupons: List<Coupon>, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        //return CouponFragment.newInstance(coupons[position])
        return CouponFragment.newInstance(coupons[position])
    }

    override fun getCount(): Int {
        return coupons.size
    }

}