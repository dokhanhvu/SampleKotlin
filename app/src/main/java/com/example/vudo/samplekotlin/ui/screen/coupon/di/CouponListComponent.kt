package com.example.vudo.samplekotlin.ui.screen.coupon.di

import com.example.vudo.samplekotlin.app.di.component.ApplicationComponent
import com.example.vudo.samplekotlin.app.di.module.ActivityModule
import com.example.vudo.samplekotlin.app.di.scope.PerNonApplication
import com.example.vudo.samplekotlin.ui.screen.coupon.view.CouponListActivity
import dagger.Component

/**
 * Created by vu.do on 4/20/2018.
 */
@PerNonApplication
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class, CouponListModule::class])
interface CouponListComponent {

    fun inject(couponListActivity: CouponListActivity)

}