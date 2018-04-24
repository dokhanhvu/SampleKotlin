package com.example.vudo.samplekotlin.ui.screen.coupon.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.vudo.samplekotlin.app.KotlinSampleApplication
import com.example.vudo.samplekotlin.app.di.module.ActivityModule
import com.example.vudo.samplekotlin.BR
import com.example.vudo.samplekotlin.R
import com.example.vudo.samplekotlin.databinding.FragmentCouponBinding
import com.example.vudo.samplekotlin.model.Coupon
import com.example.vudo.samplekotlin.ui.screen.base.BaseFragment
import com.example.vudo.samplekotlin.ui.screen.coupon.CouponItemNavigator
import com.example.vudo.samplekotlin.ui.screen.coupon.ViewModel.CouponItemViewModel
import com.example.vudo.samplekotlin.ui.screen.coupon.di.*
import java.io.Serializable
import javax.inject.Inject


/**
 * Created by vu.do on 4/19/2018.
 */
class CouponFragment : BaseFragment<FragmentCouponBinding, CouponItemViewModel>(), CouponItemNavigator {

    lateinit var mCouponItemViewModel : CouponItemViewModel

    var component : CouponItemComponent? = null

    lateinit var coupon: Coupon

    override fun getVariable(): Int {
        return BR.couponItemViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_coupon
    }

    override fun getViewModel(): CouponItemViewModel {
        return mCouponItemViewModel
    }

    fun getFragmentComponent() : CouponItemComponent?{
        if (component == null) {
            setUpInject()
        }
        return component
    }

    private fun setUpInject(){
        component = DaggerCouponItemComponent.builder()
                .couponItemModule(CouponItemModule())
                .activityModule(ActivityModule(activity as AppCompatActivity))
                .applicationComponent((KotlinSampleApplication.get(activity as AppCompatActivity)).getApplicationComponent())
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        getFragmentComponent()?.ịnject(this)
        super.onCreate(savedInstanceState)
        coupon = arguments.getSerializable("Extra") as Coupon
        mCouponItemViewModel = CouponItemViewModel(coupon)
        mViewModel = getViewModel()
        mViewModel.setNavigator(this)
        lifecycle.addObserver(mViewModel)
    }

    companion object {
        fun newInstance(coupon: Coupon): CouponFragment {
            var args : Bundle = Bundle()
            args.putSerializable("Extra", coupon as Serializable)
            var fragment : CouponFragment = CouponFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun openDetailCoupon() {
        var dialog : DetailDialog = DetailDialog.newInstance(coupon)
        dialog.show(fragmentManager,"")
    }

}