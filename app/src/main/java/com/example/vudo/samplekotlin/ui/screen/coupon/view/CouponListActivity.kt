package com.example.vudo.samplekotlin.ui.screen.coupon.view

import android.os.Bundle
import com.example.vudo.samplekotlin.BR
import com.example.vudo.samplekotlin.R
import com.example.vudo.samplekotlin.app.KotlinSampleApplication
import com.example.vudo.samplekotlin.app.di.module.ActivityModule
import com.example.vudo.samplekotlin.databinding.ActivityCouponListBinding
import com.example.vudo.samplekotlin.model.Coupon
import com.example.vudo.samplekotlin.ui.screen.base.BaseActivity
import com.example.vudo.samplekotlin.ui.screen.coupon.CouponListNavigator
import com.example.vudo.samplekotlin.ui.screen.coupon.ViewModel.CouponListViewModel
import com.example.vudo.samplekotlin.ui.screen.coupon.di.CouponListComponent
import com.example.vudo.samplekotlin.ui.screen.coupon.di.CouponListModule
import com.example.vudo.samplekotlin.ui.screen.coupon.di.DaggerCouponListComponent
import javax.inject.Inject

/**
 * Created by vu.do on 4/18/2018.
 */
class CouponListActivity : BaseActivity<ActivityCouponListBinding, CouponListViewModel>(), CouponListNavigator {

    @Inject
    lateinit var mCouponListViewModel: CouponListViewModel

    var component : CouponListComponent? = null

    var fragmentsPagerAdapter : FragmentPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent()?.inject(this)
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)
        mViewModel.getCoupons()
        lifecycle.addObserver(mViewModel)
    }

    fun getActivityComponent() : CouponListComponent?{
        if (component == null) {
            setUpInject()
        }
        return component
    }

    fun setUpInject(){
        component = DaggerCouponListComponent.builder()
                .couponListModule(CouponListModule())
                .activityModule(ActivityModule(this))
                .applicationComponent((KotlinSampleApplication()).getApplicationComponent())
                .build()
    }

    override fun getViewModel(): CouponListViewModel {
        return mCouponListViewModel
    }

    override fun getVariable(): Int {
        return BR.couponListViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_coupon_list
    }

    override fun getCouponFailed(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCouponSuccessfully(coupons: List<Coupon>) {
        fragmentsPagerAdapter  = FragmentPagerAdapter(coupons, supportFragmentManager)
        mViewDataBinding.viewPager.adapter = fragmentsPagerAdapter
        mViewDataBinding.indicator.setViewPager(mViewDataBinding.viewPager)
    }

}